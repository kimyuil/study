package Person;

public class Step extends Person {

    public Step(String name, String kind) {
        super(name, kind + " 스텝");
    }

    public void doWork() {
        System.out.println(super.getMyInfo() + " 할일을 합니다");
    }

    @Override
    public void prepareWork() {
        System.out.println(super.getMyInfo() + " 자신의 물품을 챙깁니다");
    }

    @Override
    public void cleanWork() {
        System.out.println(super.getMyInfo() + " 자신의 물품을 정리합니다");
    }
}
