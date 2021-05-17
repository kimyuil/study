package Person;

public class PotoStep extends Step {

    public PotoStep(String name) {
        super(name, "촬영");
    }

    @Override
    public void doWork() {
        System.out.println(getMyInfo() + "촬영을 합니다");
    }
}
