package Process;

import java.util.List;

import Person.Person;
import Person.Preacher;

public class FinalPray extends ServiceProcess implements IDoProcess {

    @Override
    public void doProcess(List<Person> member) {
        for (Person mem : member) {
            if (mem instanceof Preacher) {
                ((Preacher) mem).prayLast();
            }
        }
    }

}
