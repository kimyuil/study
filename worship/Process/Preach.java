package Process;

import java.util.List;

import Person.Person;
import Person.Preacher;

public class Preach extends ServiceProcess {

    @Override
    public void doProcess(List<Person> member) {
        for (Person mem : member) {
            if (mem instanceof Preacher) {
                ((Preacher) mem).doWork();
            }
        }
    }

}
