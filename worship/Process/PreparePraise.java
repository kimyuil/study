package Process;

import java.util.List;

import Persion.Persion;
import Persion.*;

public class PreparePraise extends ServiceProcess {

    @Override
    public void doProcess(List<Persion> member) {
        for(Persion mem : member){
            if(mem instanceof Step){
                ((Step)mem).doWork();
            }
        }
    }
    
}
