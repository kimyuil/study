package movie;

public class SongMovie implements Movie{
    String 가사;
    String 음악;

    public SongMovie(String 가사, String 음악){
        this.가사 = 가사;
        this.음악 = 음악;
    }

    public void show(){
        System.out.println("영상자막 : " + 가사);
        System.out.println("영상음악 : " + 음악);
    }

    public String get가사(){
        return 가사;
    }
}
