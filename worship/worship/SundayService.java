package worship;

import java.util.ArrayList;
import java.util.List;

import Person.*;
import Process.*;

public class SundayService extends Worship implements IAssignPersion, ICleanWorship, IPrepareWorship, IStartWorship {

    public SundayService() {
        super("주일예배", "일요일");
        List<ServiceProcess> process = new ArrayList<>();
        process.add(new PreparePraise());
        process.add(new PrayBeforeSermon());
        process.add(new Preach());
        process.add(new FinalPray());
        super.process = process;
    }

    public boolean assignPersion(List<Person> member) {
        int preacher = 1;
        int potoStep = 2;
        int guideStep = 2;
        System.out.println("할당 인원을 배치합니다.");

        for (Person m : member) {
            if (m instanceof Preacher) {
                preacher--;
            } else if (m instanceof PotoStep) {
                potoStep--;
            } else if (m instanceof GuideStep) {
                guideStep--;
            } else {

            }
        }

        if (preacher == 0 && guideStep <= 0 && potoStep <= 0) {
            super.member = member;
            return true;
        } else {
            System.out.println("준비인원이 맞지 않습니다. 설교자 1명, 촬영스텝 2명이상, 안내스텝 2명이상 필요");
            return false;
        }
        // 다 통과했다면

    }

    @Override
    public void prepareWorship() {
        System.out.println("예배를 준비합니다.");
        for (Person p : super.member) {
            p.prepareWork();
        }
    }

    @Override
    public void cleanWorship() {
        System.out.println("예배를 정리합니다. 사람들이 마무리 작업을 시작합니다.");
        for (Person p : super.member) {
            p.cleanWork();
        }
        System.out.println("모두 마무리되었습니다. 집에갑시다.");
    }

    @Override
    public void startWorship() {
        System.out.println("------------------");
        System.out.println(this.getDay() + " " + this.getName() + " 시작합니다..");

        for (ServiceProcess process : super.process) {
            System.out.println("===================");
            process.doProcess(super.member);
        }

        System.out.println(this.getDay() + " " + this.getName() + " 끝났습니다.");
        System.out.println("------------------");

    }
}
