package Process;

import java.util.List;

import Persion.Persion;
import Persion.*;

public class PrayBeforeSermon extends ServiceProcess {

    @Override
    public void doProcess(List<Persion> member) {
        for (Persion mem : member) {
            if (mem instanceof Singer) {
                ((Singer) mem).endSing();
            }
        }
    }

}
