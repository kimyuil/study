package Person;

import java.lang.reflect.Constructor;

public class Preacher extends Person implements IPrepareWork, IDoWork, ICleanWork {

    public Preacher(String name) {
        super(name, "설교자");
    }

    public void doWork() {
        System.out.println(super.getMyInfo() + "설교를 합니다");
    }

    public void prayLast() {
        System.out.println(super.getMyInfo() + " 마무리 기도를 합니다. 아멘");
    }

    @Override
    public void prepareWork() {
        System.out.println(super.getMyInfo() + "원고를 작성하고 연습합니다.");
    }

    @Override
    public void cleanWork() {
        System.out.println(super.getMyInfo() + "원고를 정리하고 교인들에게 말을 걸며 대화합니다");
    }
}
