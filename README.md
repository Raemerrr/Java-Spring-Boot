Java Spring Boot Study
===================
----------


Documents
-------------

> **Note:**  
> 해당 내용은 'Seoul Wiz'의 Spring 강좌를 참고 하였습니다.   
(https://www.youtube.com/watch?v=CsOrR-4nH-s&list=PLPvokKzUkaLeiLUDKpqRdP8jtLU8lLKgR)   
> - 2020.06.08 프로젝트 생성.    
>**:: Spring Boot ::        (v2.2.2.RELEASE)**  
>  
> - 2020.06.11 5강     
>**:: DI사용에 따른 장점 ::        **  
>   
> - 2020.06.12 DI(Dependency Inversion) 학습!       
>**:: 1장 기본기 확실히 익히기 ::  **  
>  간단하게 Interface의 활용과 비슷하다고 생각하자.  
>  ex) 상황 : 4B 굵기 팬 사용 -> 6B 굵기 팬 사용 -> 6B와 지우개 팬사용  
>  코드 : pencil.use();  
> bean pencil class = 4B 굵기 사용  
> bean pencil class = 6B 굵기 사용  
> bean pencil class = 6B 굵기&지우개 사용  
>  이처럼 구현 코드상의 변경 없이 의존성 주입부만 바꿔 동작하게 할 수 있다.  
>  
> - 2020.06.13 6강     
>  DI 설정 방법 - XML방식, JAVA방식, XML&JAVA방식  
>  
> - 2020.06.14 7강 ~ 8강  
> **:: 7강 생명주기(Life Cycle)와 범위(Scope)**  
>  getBean()을 하게 되면 가져다 쓰겠다는 의미  
>  a = getBean(obj);  
>  b = getBean(obj);  
>  둘은 같은 객체를 바라보는 상태  
>  b를 이용해 값을 수정 하면 a의 값도 변경된다.      
> **:: 8강 외부 파일을 이용한 설정**  
>   -외부 파일에서 설정 값 얻어오기 ex) 관리자 계정 정보  
>   -profile 설정 이용하기 ex) 개발망, 외부망 나눠서 작업 가능  
>     
>     
> **Ps:**   
> - 지속 업데이트 예정  

----------
