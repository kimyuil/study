package 물고기;

import 먹이.먹이;

import java.util.List;

public class 구피 extends 물고기 {

    public 구피(){
        this.최대ph = 8.0;
        this.최소ph = 6.0;
        this.요구포만도 = 1;
        this.현재포만도 = 0;

        this.길이 = 3;
        this.색깔 = "연한색깔";
    }

    @Override
    public int 먹이먹고_배설하다(먹이 먹이) {

        this.현재포만도 += 먹이.get포만감();
        return 먹이.get포만감();
    }

    @Override
    public boolean 배부름여부() {
        return this.현재포만도 >= this.요구포만도;
    }

    @Override
    public void 성장하다() {

        this.길이 += 2;
        this.요구포만도 += 1;
        System.out.println("구피 1마리가 성장했습니다.");
    }

}
