Java Spring Boot Study
===================
----------


Documents
-------------

> **Note:**  
> 해당 내용은 'Seoul Wiz'의 Spring 강좌를 참고 하였습니다.   
(https://www.youtube.com/watch?v=CsOrR-4nH-s&list=PLPvokKzUkaLeiLUDKpqRdP8jtLU8lLKgR)   
> 　  
> - **2020.06.08 프로젝트 생성**      
> Spring Boot (v2.2.2.RELEASE)   
>  　  
> - **2020.06.11 5강**       
>:: DI사용에 따른 장점 ::          
>   　  
> - **2020.06.12 DI(Dependency Inversion) 학습!**         
>:: 1장 기본기 확실히 익히기 ::   
>  간단하게 Interface의 활용과 비슷하다고 생각하자.  
>  ex) 상황 : 4B 굵기 팬 사용 -> 6B 굵기 팬 사용 -> 6B와 지우개 팬사용  
>  코드 : pencil.use();  
> bean pencil class = 4B 굵기 사용  
> bean pencil class = 6B 굵기 사용  
> bean pencil class = 6B 굵기&지우개 사용  
>  이처럼 구현 코드상의 변경 없이 의존성 주입부만 바꿔 동작하게 할 수 있다.  
>  　  
> - **2020.06.13 6강**       
>  DI 설정 방법 - XML방식, JAVA방식, XML&JAVA방식  
>  　  
> - **2020.06.14 7강 ~ 8강  **  
> :: 7강 생명주기(Life Cycle)와 범위(Scope)  
>  getBean()을 하게 되면 가져다 쓰겠다는 의미
>  a = getBean(obj);
>  b = getBean(obj);
>  둘은 같은 객체를 바라보는 상태
>  b를 이용해 값을 수정 하면 a의 값도 변경된다.     
>   　   
> :: 8강 외부 파일을 이용한 설정  
>   -외부 파일에서 설정 값 얻어오기 ex) 관리자 계정 정보  
>   -profile 설정 이용하기 ex) 개발망, 외부망 나눠서 작업 가능   
>     　  
> - **2020.06.15 9강**    
>  AOP란?  
>  Aspect : 공통 기능  
>  Advice : Aspect의 기능 자체  
>  Joinpoint : Advice를 적용해야 되는 부분 ex) 필드, 메소드)(스프링에서는 메소드만 해당)   
>  Pointcut : Joinpoint의 부분으로 실제로 Advice가 적용된 부분  
>  Weaving : Advice를 핵심 기능에 적용 하는 범위   
>  AOP 구현  
>  1) 의존성 설정 (pom.xml)  
>  2) 공통 기능의 클랫 제작 - Advice 역할 클래스  
>  3) XML 설정 파일에 Aspect설정   
>   　  
> - **2020.06.18 9강 이슈...**     
>  AOP 설정 오류.. - https://blog.naver.com/rkdfoals/222005244514 참고  
>   요즘.. 야근과 외근이 많다... 진도를 못나가고 있다..  화이팅..!   
>     　  
> - **2020.06.19 10강**  
>  https://blog.naver.com/rkdfoals?Redirect=Write&categoryNo=19
>  　  
> **Ps:**   
> - 지속 업데이트 예정  
> - 2020-06-19 블로그(https://blog.naver.com/rkdfoals)에 내용 업로드 예정  

----------
