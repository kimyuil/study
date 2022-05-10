package 여과기.물리여과재;

import 어항.어항;

public class 성긴필터 implements 물리적여과재 {

    final int 최대여과력 = 30;
    int 여과력 = 최대여과력;

    public void 여과작용(어항 어항){
        // 어항의 오염물질 줄이기
        if(어항.오염물질 <= 0){
            System.out.println("오염물질이 없어 내구도가 닳지 않습니다. 현재 여과력 : " + 여과력);
            return;
        }
        어항.오염물질 -= 여과력;
        if(어항.오염물질 < 0){
            어항.오염물질 = 0;
        }
        여과력 -= 1;
        System.out.println("여과작용 진행하면서 내구도가 닳았습니다. 현재 여과력 : " + 여과력);
    }

    @Override
    public int get여과력() {
        return 여과력;
    }
}
