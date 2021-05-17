package Process;

import java.util.List;

import Persion.Persion;
import Persion.Preacher;

public class FinalPray extends ServiceProcess {

    @Override
    public void doProcess(List<Persion> member) {
        for (Persion mem : member) {
            if (mem instanceof Preacher) {
                ((Preacher) mem).prayLast();
            }
        }
    }

}