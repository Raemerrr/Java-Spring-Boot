> 해당 내용은 인프런 김영한 강사님의 `자바 ORM 표준 JPA 프로그래밍 - 기본편`을 보고 작성하였으며, 문제가 있을 시 바로 삭제하도록 하겠습니다.

## 목차 🚀
- [JPA 시작하기](#jpa-시작하기)
- [영속성 관리 - 내부 동작 방식](#영속성-관리---내부-동작-방식)
- [엔티티 매핑](#엔티티-매핑)
---

#### JPA 시작하기

* Hello JPA - 프로젝트 생성
    * persistence.xml 작성
        ```xml
      <!-- JPA DBMS 드라이버 옵션 (MySQL, Oracle, MS-SQL 등.. 설정 가능) -->
      <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
      <!-- 각 DBMS(MySQL, Oracle, MS-SQL 등..) 특정 구문에 대한 처리를 위한 설정 -->
      <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
      ```
* Hello JPA - 애플리케이션 개발
    * hellojpa.JpaMian.java
        ```java
        /**
        * EntityManagerFactory는 애플리케이션 로딩 시점에 딱 하나만 생성하도록 한다!!
        * 여기서의 hello는 persistence.xml에서 작성한 <persistence-unit name="hello"> 값
        */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        /** 
        * DB 커넥션을 얻어 쿼리를 날리고 종료하는 하나의 일괄적인 단위를 할때 마다 EntityManager를 생성한다.
        * 주의 * EntityManager는 Thread간 공유 금지!!  
        */
        EntityManager em = emf.createEntityManager();
        ```
        * JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        ```java
      EntityTransaction transaction = em.getTransaction();      
      // 작업 전                                                    
      transaction.begin();
      // 작업
      em.persist("원하는 동작");
      // 작업 후
      transaction.commit();
        ```
    * hellojpa.Member.java
        ```java
        // @Entity : JPA가 로딩될 때 JPA가 관리해야하는 객체인 것을 알 수 있다.
        import javax.persistence.Entity;
        @Entity
        ```
    * JPQL
        * 앤티티 객체를 중심으로 개발
            ```sql 
            -- 여기서의 Member는 테이블이 아닌 객체를 의미한다.
            select m from Member as m
            ```
        * 애플리케이션이 필요한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요!
      > 1. JPQL은 엔티티 객체를 대상으로 쿼리 (객체지향 쿼리)
      > 2. SQL은 데이터베이스 테이블을 대상으로 쿼리

#### 영속성 관리 - 내부 동작 방식

* 영속성 컨텍스트 1
    * JPA에서 가장 중요한 2가지
      > 1. 객체와 관계형 데이터베이스 매핑하기
      > 2. 영속성 컨텍스트 : `"엔티티를 영구 저장하는 환경"`
    * EntityManager.persist(entity); 메서드 실행 시
      > 1. EntityManager를 통해 Entity를 영속성 컨텍스트라는 곳에 저장하는것을 의미
      > 2. 트랜잭션이 커밋되기 전까진 DB에 반영되지 않는다!
* 영속성 컨텍스트 2
    * 영속성 컨텍스트는 내부에 `1차 캐시`를 가지고 있다.
        * 1차 캐시는 내부적으로 클래스 멤버 변수로 지정했던 @Id가 키가 되고 Entity(객체)가 값이 된다.
            ```java
          @Entity
          public class Member {
              @Id // 이 값이 키가 되어 영속성 컨텍스트 1차 캐시에 저장된다.
              private Long id;
              ...
          }
          ```
        * EntityManager는 DB트랜잭션 단위로 생성하고 지운다.
            * `영속성 컨텍스트` - DB트랜잭션 단위로 생성되고 지워진다.
            * `1차 캐시` - DB트랜잭션 단위로 생성되고 지워진다.
            * `1차 캐시`는 찰나의 순간(DB트랜잭션 단위)에서만 이득이 있다..(?)
            * 성능 보다는 객체지향적 관점에서 이점이 있다.
    * 영속 엔티티의 동일성 보장
      > 1차 캐시로 반복 가능한 읽기 등급의 트랜잭션 격리 수준을 DB가 아닌 애플리케이션 차원에서 제공
        ```java
      Member a = em.find(Member.class , "memeber1");
      Member b = em.find(Member.class , "memeber1");
      Member c = a;
      
      /**
      * 아래의 결과가 true인것은 같은 주솟값을 가진 객체라는것의 증명
      */
      System.out.println(a == b); // true 출력
      
      // 검증 - 주솟값이 같다면 영속성을 유지한 엔티티인가?
      c.setName("Raemerrr");
      
      System.out.println(c == b); // true 출력
      /**
      * 객체 c를 수정해도 b에 반영된다. 즉 같은 주솟값을 가진 객체다.
      * 객체지향적 관점으로 봐도 당연한 결과이다. 
      */
      System.out.println(b.getName()); // "Raemerrr"       
        ```
* 플러시
    > 영속성 컨텍스트의 변경내용을 데이터베이스에 반영
    * 플러시 발생 시
        * 변경 감지
        * 수정된 Entity `쓰기 지연 SQL 저장소`에 등록
        * `쓰기 지연 SQL 저장소`의 쿼리를 데이터베이스에 전송(등록, 수정, 삭제 등)
    * 영속성 컨텍스트를 플러시하는 방법
        * 트랜잭션 커밋 - 플러시 자동 호출
        * JPQL 쿼리 실행 - 플러시 자동 호출
        * em.flush() - 직접 호출 (em.flush() 한다고 해서 1차 캐시를 비우는 것은 아님)
    * JPQL 쿼리 실행 시 플러시가 자동으로 호출되는 이유
        ```java
      em.persist(entity1);
      em.persist(entity2);
      em.persist(entity3);
      /**
      * 중간에 JPQL 실행한다면 DB에 값이 없다면 아무것도 얻어 올 수 없음...
      * 그러므로 JPQL 쿼리 실행 시 플러시가 자동으로 호출된다.
      */
      query = em.createQuery("select m from Member as m", Member.class);
      List<Member> list = query.getResultList);
      ```
#### 엔티티 매핑

* 객체와 테이블 매핑
    * @Entity가 붙은 클래스는 JPA가 관리, 엔티티라 한다.
    * 주의
        > * 기본 생서자 필수(파라미터가 없는 `public` 또는 `protected` 생성자)
        > * final class , enum, interface, inner class 에는 사용하지 않는다!
        > * 저장할 필드에 final 사용 X (DB에 저장할 필드가 중간에 변경 되지 않는 경우가 있는가..)
* 데이터베이스 스키마 자동 생성
    * resources/META-INF/persistence.xml 설정
        ```xml
        <property name="hibernate.hbm2ddl.auto" value="create" />
        ```
        > * 🔥`주의` 개발 환경에서만 사용!
        > * 운영 시 `절대!` `create`, `create-drop`, `update` 옵션 사용하지마라!
* 필드와 컬럼 매핑
    > * 🔥`주의` enum 타입은 @Enumerated(EnumType.STRING)를 꼭 설정하여 사용하자.
* 기본 키 매핑
    * @SequenceGenerator, @TableGenerator 사용 시 최적화를 위한 옵션 (50 ~ 100 적절)
        ```java
      /**
      * 기본 키 id 값이 자동 증가할 때마다 DB를 직접 호출하는 것이 아닌 메모리에서 얻도록
      * 미리 allocationSize 만큼 보유 하고 allocationSize를 넘어서면 새로 요청하는 것!
      */
      @SequenceGenerator(
      ...
      initialValue = 1, allocationSize = 50)
        ```
#### 연관관계 매핑 기초
* 🔥`테이블`과 `객체` 서로 다른 관점
    > * 테이블은 외래 키 조인을 사용해서 연관된 테이블을 찾는다.
    > * 객체는 참조를 사용해서 연관된 객체를 찾는다.
* 단방향 연관관계
    * Member에서 Team에 대한 정보가 필요하고, Team에서는 Member에 대한 정보가 필요하지 않을때.
    ```java
  @Entity
  public class Member() {
      @Id
      @GeneratedValue
      private Long id;
  
      /**
      * AS-IS
      * teamId 값을 조회해서 Team 객체를 찾는 비효율적인 방법
      */
      // private Long teamId;
      
      /**
      * TO-BE
      * 단방향 연관관계를 맺어 연관된 객체를 가진다.
      * Team 객체에서는 Member 객체에 대해 알필요가 없기에 단방향 연결.
      */
      @ManyToOne
      private Team team;
      ...
  }
  
  public class Team() {
      @Id
      @GeneratedValue
      private Long id;
      ...
  }
    ```