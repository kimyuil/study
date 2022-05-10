import 먹이.냉짱;
import 먹이.핑퐁;
import 물고기.구피;
import 물고기.플래티;
import 바닥재.오색사;
import 어항.어항;
import 여과기.물리여과재.성긴필터;
import 여과기.스펀지여과기;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("물생활!");

        스펀지여과기 스펀지여과기 = new 스펀지여과기();
        스펀지여과기.왼쪽여과재교체(new 성긴필터());
        스펀지여과기.오른쪽여과재교체(new 성긴필터());
        오색사 바닥재 = new 오색사();

        어항 나의어항 = 어항.of(List.of(스펀지여과기), 20, 바닥재);
        System.out.println("##### 첫째날 #####");
        나의어항.물고기투입(new 구피());
        나의어항.먹이주기(List.of(new 핑퐁()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }

        System.out.println("##### 둘째날 #####");
        나의어항.먹이주기(List.of(new 핑퐁()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }
        System.out.println("##### 셋째날 #####");
        나의어항.물고기투입(new 플래티());
        나의어항.먹이주기(List.of(new 핑퐁(), new 냉짱()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }

        System.out.println("##### 넷째날 #####");
        나의어항.먹이주기(List.of(new 핑퐁(), new 냉짱(), new 냉짱(), new 냉짱()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }

        System.out.println("##### 다섯째날 #####");
        나의어항.먹이주기(List.of(new 핑퐁(), new 핑퐁()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }
        for(var f : 나의어항.물고기들){
            f.성장하다();
        }

        System.out.println("##### 여섯째날 #####");
        나의어항.먹이주기(List.of(new 핑퐁(), new 핑퐁()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }
        System.out.println("##### 일곱째날 #####");
        나의어항.먹이주기(List.of(new 핑퐁(), new 핑퐁()));
        for(var 여과기 : 나의어항.여과기){
            여과기.여과하다(나의어항);
        }

    }
}