package Persion;

public class GuideStep extends Step {

    public GuideStep(String name) {
        super(name, "안내");
    }

    @Override
    public void doWork() {
        System.out.println(getMyInfo() + "들어오는 사람들에게 자리를 안내합니다");
    }

}
