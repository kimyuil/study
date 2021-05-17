package Person;

public class Person implements IPrepareWork, IDoWork, ICleanWork {

    String name;
    String position;

    Person(String name, String position) {
        this.name = name;
        this.position = position;
    }

    Person() {
    }

    public String getMyInfo() {
        return name + " " + position;
    }

    @Override
    public void cleanWork() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doWork() {
        // TODO Auto-generated method stub
    }

    @Override
    public void prepareWork() {
        // TODO Auto-generated method stub
    }
}
