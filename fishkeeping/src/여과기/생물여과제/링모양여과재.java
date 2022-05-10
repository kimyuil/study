package 여과기.생물여과제;

import 어항.어항;

public class 링모양여과재 implements 생물학적여과재 {

    final int MAX_여과력 = 100;
    int 여과력 = 0;

    @Override
    public void 박테리아증식(어항 어항) {
        if(여과력 < MAX_여과력){
            여과력 += 5;
        }
    }

    @Override
    public void 여과작용(어항 어항) {
        if(어항.오염물질 <= 0){
            System.out.println("오염물질이 없습니다.");
            return;
        }
        어항.오염물질 -= 여과력;
        if(어항.오염물질 < 0){
            어항.오염물질 = 0;
        }
    }

    @Override
    public int get여과력() {
        return 여과력;
    }
}
