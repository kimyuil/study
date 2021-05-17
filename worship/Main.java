import java.util.*;

import Persion.*;
import worship.*;

public class Main {
    public static void main(String[] args) {
        // 1. 예배 필요 인원 준비
        List<Persion> members = new ArrayList<>();
        members.add(new Preacher("정조은"));
        members.add(new PotoStep("김유일"));
        members.add(new PotoStep("고명진"));
        members.add(new GuideStep("조용진"));
        members.add(new GuideStep("땜방"));
        members.add(new Singer("김찬양"));

        // 2. 예배 진행
        Worship sunday = new SundayService();
        if (sunday.assignPersion(members)) {
            sunday.progressService();
        } else {
            System.out.println("죄송합니다");
        }
    }
}
