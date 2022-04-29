package person;

public class RepresentativePrayer extends Speacher{

    String 기도내용;

    public RepresentativePrayer(String name) {
        super(name);
    }

    public void set기도내용(String script){
        this.기도내용 = script;
    }

    public void 기도하다(){
        System.out.println(name);
        if(mike == null){
            System.out.println("대표기도자 마이크가 없습니다");
            return;
        }
        mike.speak(기도내용);
    }

}
