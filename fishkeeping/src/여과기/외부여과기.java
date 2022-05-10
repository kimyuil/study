package 여과기;

import 어항.어항;
import 여과기.물리여과재.물리적여과재;
import 여과기.생물여과제.생물학적여과재;

import java.util.List;

public class 외부여과기 implements I여과기 {

    List<물리적여과재> 물리여과재들;
    List<생물학적여과재> 생물여과재들;

    public void 여과재세팅(List<물리적여과재> 물리여과재들, List<생물학적여과재> 생물여과재들){
        this.물리여과재들 = 물리여과재들;
        this.생물여과재들 = 생물여과재들;
    }

    public 물리적여과재 가장더러운_물리여과재_교체(물리적여과재 여과제){

        if(물리여과재들 == null){
            return null;
        }

        int min여과력 = 물리여과재들.get(0).get여과력();
        int deleteIndex = 0;
        물리적여과재 toDelete = 물리여과재들.get(0);

        for(int i = 0  ; i < 물리여과재들.size() ; i++){
            if(min여과력 > 물리여과재들.get(i).get여과력()){
                min여과력 = 물리여과재들.get(i).get여과력();
                deleteIndex = i;
                toDelete = 물리여과재들.get(i);
            }
        }
        물리여과재들.set(deleteIndex, 여과제);
        System.out.println("여과제가 교체되었습니다.");
        return toDelete;
    }

    @Override
    public void 여과하다(어항 어항) {
        if( (물리여과재들 == null && 생물여과재들==null)){
            System.out.println("여과제가 없습니다. 여과재를 넣어주세요.");
            return;
        }
        int 여과력 = 0;
        for(var s : 물리여과재들){
            여과력 += s.get여과력();
        }
        if(여과력 <= 0){
            System.out.println("물리 여과재를 교체해주세요. 여과는 진행됩니다.");
        }

        System.out.println("원래 오염정도 : "+어항.오염물질);
        for(var s : 물리여과재들){
            s.여과작용(어항);
        }
        for(var s : 생물여과재들){
            s.여과작용(어항);
        }

        System.out.println("어항의 오염물질을 걸러냈습니다. 오염정도 : "+어항.오염물질);
    }
}
