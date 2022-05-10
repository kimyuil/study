package 어항;

import 먹이.먹이;
import 물고기.물고기;
import 바닥재.바닥재;
import 여과기.I여과기;

import java.util.ArrayList;
import java.util.List;

public class 어항 {

    public int 크기;

    public List<I여과기> 여과기;

    public 바닥재 바닥재;

    public int 오염물질;

    public int 이끼;

    public List<물고기> 물고기들;

    public static 어항 of(List<I여과기> 여과기, int 크기, 바닥재 바닥재){
        어항 어항 = new 어항();
        어항.여과기 = 여과기;
        어항.크기 = 크기;
        어항.바닥재 = 바닥재;
        어항.이끼 = 0;
        어항.오염물질 = 0;
        어항.물고기들 = new ArrayList<>();
        return 어항;
    }

    public void 물고기투입(물고기 fish){
        System.out.println("물맞댐 진행 (시간 ~분 소요)");
        if(fish.phCheck(this)){
            this.물고기들.add(fish);
        }else{
            System.out.println("ph가 맞지 않습니다.");
            return;
        }
    }

    public void 먹이주기(List<먹이> 먹이들){
        for(var food : 먹이들){
            for(var fish : 물고기들){
                if (fish.배부름여부()){
                    continue;
                }
                this.오염물질 += fish.먹이먹고_배설하다(food);
                break;
            }
            this.오염물질 += food.get오염도();
        }

        System.out.println("먹이준 결과 오염물질 양 : " + 오염물질);
        for(var fish : 물고기들){
            if (!fish.배부름여부()){
                System.out.println("물고기가 배고픕니다.");
            }
        }

    }

    public void 이끼청소하기(){
        this.이끼 -= 10;
        if(this.이끼 < 0){
            this.이끼 = 0;
        }
    }

}
