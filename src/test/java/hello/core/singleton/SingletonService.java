package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    // 이 객체 인스턴스가 필요하다면 getInstance() 통해서만 조회할 수 있음. 항상 같은 인스턴스 반환
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
