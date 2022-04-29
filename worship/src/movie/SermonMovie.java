package movie;

public class SermonMovie implements Movie{

    String 자막;
    String 음악;

    public SermonMovie(String 자막, String 음악){
        this.자막 = 자막;
        this.음악 = 음악;
    }

    @Override
    public void show() {
        System.out.println("영상자막 : "+ 자막);
        System.out.println("영상음악 : " + 음악);
    }
}
