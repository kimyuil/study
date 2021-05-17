package Process;

import java.util.List;

import Person.*;

public class ServiceProcess implements IDoProcess {

    String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doProcess(List<Person> member) {

    }

}
