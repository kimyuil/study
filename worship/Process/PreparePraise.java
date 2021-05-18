package Process;

import java.util.List;

import Person.*;

public class PreparePraise extends ServiceProcess {

    @Override
    public void doProcess(List<Person> member) {
        for (Person mem : member) {
            if (mem instanceof Step) {
                ((Step) mem).doWork();
            }

            if (mem instanceof Singer) {
                ((Singer) mem).doWork();
            }
        }
    }

}
