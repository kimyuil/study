package 여과기;

import 어항.어항;
import 여과기.물리여과재.물리적여과재;

public class 스펀지여과기 implements I여과기 {

    물리적여과재 왼쪽여과재;
    물리적여과재 오른쪽여과재;

    public 물리적여과재 왼쪽여과재교체(물리적여과재 여과제){

        물리적여과재 기존여과재 = this.왼쪽여과재;
        this.왼쪽여과재 = 여과제;
        System.out.println("여과제가 교체되었습니다.");
        return 기존여과재;
    }

    public 물리적여과재 오른쪽여과재교체(물리적여과재 여과제){

        물리적여과재 기존여과재 = this.오른쪽여과재;
        this.오른쪽여과재 = 여과제;
        System.out.println("여과제가 교체되었습니다.");
        return 기존여과재;
    }

    @Override
    public void 여과하다(어항 어항) {
        if( (왼쪽여과재 == null && 오른쪽여과재==null) || (왼쪽여과재.get여과력()+오른쪽여과재.get여과력()) <= 0){
            System.out.println("여과할 수 없습니다. 여과재를 넣어주거나, 교체해주세요.");
            return;
        }

        System.out.println("원래 오염정도 : "+어항.오염물질);

        왼쪽여과재.여과작용(어항);
        오른쪽여과재.여과작용(어항);

        System.out.println("어항의 오염물질을 걸러냈습니다. 오염정도 : "+어항.오염물질);

    }
}
