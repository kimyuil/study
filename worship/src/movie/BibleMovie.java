package movie;

public class BibleMovie implements Movie{

    private String 성구;

    public void set성구(String s){
        성구 = s;
    }

    public void show(){
        System.out.println("영상자막 : "+성구);
        System.out.println("영상음악 : 성구 음악송출");
    }
}
