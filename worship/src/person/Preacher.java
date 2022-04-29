package person;

import person.prepare.SermonFlow;

import java.util.List;

public class Preacher extends Speacher{

    List<SermonFlow> 설교원고;
    String 마무리설교원고;

    String 축도원고;
    public Preacher(String name) {
        super(name);
    }

    public void set원고(List<SermonFlow> sermon, String 마무리설교원고, String 축도원고){

        this.설교원고 = sermon;
        this.마무리설교원고 = 마무리설교원고;
        this.축도원고 = 축도원고;
    }

    public void 설교하다(){
        System.out.println(name);
        if(mike == null){
            System.out.println("설교자 마이크가 없습니다");
            return;
        }

        for(var s : 설교원고){
            mike.speak(s.getBeforeSermon());
            s.getSermonMovie().show();
        }
        mike.speak(마무리설교원고);

    }

    public void 축도하다(){
        System.out.println(name);
        if(mike == null){
            System.out.println("설교자 마이크가 없습니다");
            return;
        }

        mike.speak(축도원고);
    }

    public List<SermonFlow> get설교원고(){
        return 설교원고;
    }
}
