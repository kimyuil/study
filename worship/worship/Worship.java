package worship;

import java.util.List;

import Person.Person;
import Process.ServiceProcess;

public class Worship implements IAssignPersion, ICleanWorship, IPrepareWorship, IStartWorship {

    protected List<Person> member;
    protected List<ServiceProcess> process;
    private String name;
    private String day;

    public Worship() {
    }

    public Worship(String name, String day) {
        this.setName(name);
        this.setDay(day);
    }

    public void progressService() {
        this.prepareWorship();
        this.startWorship();
        this.cleanWorship();
        this.endWorship();
    }

    protected void endWorship() {
        this.member = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getDay() {
        return this.day;
    }

    private void setDay(String day) {
        this.day = day;
    }

    @Override
    public void startWorship() {
    }

    @Override
    public void prepareWorship() {
    }

    @Override
    public void cleanWorship() {
    }

    @Override
    public boolean assignPersion(List<Person> member) {
        return false;
    }
}
