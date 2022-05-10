package 바닥재;

import 어항.어항;
import 여과기.생물여과제.생물학적여과재;
import 여과기.저면여과기;

abstract public class 바닥재 implements 생물학적여과재 {

    public double ph;
    abstract void show();

    final int MAX_여과력 = 70;
    int 여과력 = 0;

    @Override
    public void 박테리아증식(어항 어항) {

        // 어항에 저면여과기가 있을 때만 실행되어야함.
        boolean 여과가능여부 = false;
        for(var b : 어항.여과기){
            if(b instanceof 저면여과기){
                여과가능여부 = true;
            }
        }
        if(!여과가능여부){
            return;
        }

        if(여과력 < MAX_여과력){
            여과력 += 5;
        }
    }

    @Override
    public void 여과작용(어항 어항) {

        boolean 여과가능여부 = false;
        for(var b : 어항.여과기){
            if(b instanceof 저면여과기){
                여과가능여부 = true;
            }
        }
        if(!여과가능여부){
            return;
        }

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
