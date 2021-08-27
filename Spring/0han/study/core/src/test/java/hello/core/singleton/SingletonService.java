package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

class SingletonTest2 {
    public static void main(String[] args) {
        // SingletonService의 생성자가 private이라 외부에서 생성 불가
        //SingletonService singletonService = new SingletonService();
        SingletonService singletonService1 = SingletonService.getInstance();
        singletonService1.logic();
        SingletonService singletonService2 = SingletonService.getInstance();
        singletonService2.logic();

        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);
    }
}


