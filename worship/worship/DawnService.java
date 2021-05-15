package worship;

import java.util.List;

import Persion.Persion;

public class DawnService extends Worship{
    
    public DawnService(String day) {
        super("새벽예배", day);
    }

    @Override
    public void prepareWorship() {
        System.out.println("예배를 준비합니다.");   
    }

    @Override
    public void serviceStart() {
        System.out.println(this.getDay()+ " "+ this.getName()+" 시작합니다..");
        System.out.println(this.getDay()+ " "+ this.getName()+" 끝났습니다.");        
    }

    @Override
    public void cleanWorship() {
        System.out.println("예배를 정리합니다. 사람들이 마무리 작업을 시작합니다.");
        System.out.println("모두 마무리되었습니다. 집에갑시다.");
    }

    @Override
    public boolean assignPersion(List<Persion> member) {
        return false;
        // TODO Auto-generated method stub
        
    }
}