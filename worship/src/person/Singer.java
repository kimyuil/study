package person;

import mike.SingMike;

public class Singer extends Person{


    public Singer(String name) {
        super(name);
    }

    public void 찬양(String script){
        System.out.println(name);
        if(mike == null){
            System.out.println("싱어 마이크가 없습니다");
            return;
        }
        mike.speak(script);
    }
}
