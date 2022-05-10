package 여과기;

import 어항.어항;
import 여과기.물리여과재.물리적여과재;

public class 저면여과기 implements I여과기 {

    // 저면여과기는 바닥재가 여과제. 정확히는 생물학적 여과제.

    @Override
    public void 여과하다(어항 어항) {

        if(어항.바닥재 == null){
            System.out.println("저면여과기는 바닥재가 있어야 여과할 수 있습니다. 바닥재를 깔아주세요");
            return;
        }

        System.out.println("원래 오염정도 : "+어항.오염물질);

        어항.바닥재.여과작용(어항);

        System.out.println("어항의 오염물질을 걸러냈습니다. 오염정도 : "+어항.오염물질);

    }
}
