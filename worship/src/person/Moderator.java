package person;

public class Moderator extends Speacher{

    String 광고;
    String 대표기도;

    public void set광고(String s){
        광고 = s;
    }
    public Moderator(String name) {
        super(name);
    }

    public void 광고하다(){
        System.out.println(name);
        mike.speak(광고);
    }

    public void set대표기도(String s){
        this.대표기도 = s;
    }
    public void 대표기도() {
        System.out.println(name);
        mike.speak(대표기도);
    }
}
