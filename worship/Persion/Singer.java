package Persion;

public class Singer extends Persion {

    public Singer(String name) {
        super(name, "싱어");
    }

    @Override
    public void prepareWork() {
        System.out.println(getMyInfo() + " 목을 풉니다");
    }

    @Override
    public void cleanWork() {
        System.out.println(getMyInfo() + " 마이크를 정리합니다");

    }

    @Override
    public void doWork() {
        System.out.println(getMyInfo() + " 찬양을 합니다");
    }

    public void endSing() {
        System.out.println(getMyInfo() + " 좌석으로 이동합니다");
    }

}
