package Process;

import java.util.List;

import Persion.*;

public abstract class ServiceProcess {

    String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void doProcess(List<Persion> member);

}
