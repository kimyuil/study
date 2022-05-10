package 물고기;

import 먹이.먹이;
import 어항.어항;

import java.util.List;

abstract public class 물고기 {

    double 최소ph;
    double 최대ph;

    int 길이;
    String 색깔;

    int 요구포만도;
    int 현재포만도 = 0;

    public boolean phCheck(어항 어항){
        return 어항.바닥재.ph >= 최소ph && 어항.바닥재.ph <= 최대ph;
    }
    abstract public int 먹이먹고_배설하다(먹이 먹이);
    abstract public boolean 배부름여부();
    abstract public void 성장하다();

}
