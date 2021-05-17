package Process;

import java.util.List;

import Person.*;

public class PrayBeforeSermon extends ServiceProcess implements IDoProcess {

    @Override
    public void doProcess(List<Person> member) {
        for (Person mem : member) {
            if (mem instanceof Singer) {
                ((Singer) mem).endSing();
            }
        }
    }

}
