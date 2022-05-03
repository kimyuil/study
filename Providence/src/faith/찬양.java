package faith;

public class 찬양 {
  String 가사;
  String 음악;

  public 찬양(String 가사, String 음악){
    this.가사 = 가사;
    this.음악 = 음악;
  }

  public void play(){
    System.out.println("찬양음악 : " + 음악);
    System.out.println("찬양가사 : " + 가사);
  }
}
