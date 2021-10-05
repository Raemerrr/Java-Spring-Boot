> 해당 내용은 인프런 김영한 강사님의 `자바 ORM 표준 JPA 프로그래밍 - 기본편`을 보고 작성하였으며, 문제가 있을 시 바로 삭제하도록 하겠습니다.

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
        > JPQL은 엔티티 객체를 대상으로 쿼리 (객체지향 쿼리) <br> SQL은 데이터베이스 테이블을 대상으로 쿼리
    