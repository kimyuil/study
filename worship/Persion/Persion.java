package Persion;

public abstract class Persion {

    String name;
    String position;

    Persion(String name, String position){
        this.name = name;
        this.position = position;
    }
    Persion(){}

    public String getMyInfo(){
        return name+" "+position;
    }
    
    public abstract void prepareWork();
    public abstract void cleanWork();
}

