package god;

import faith.기도;
import faith.말씀;

public class 성령님 {

  static public 말씀 말씀을주시다(기도 기도){
    var rand = UniqueRandom.getInstance();
    return new 말씀("깊은 세밀한 성령님 말씀-"+rand.getRandomNumber(기도.get기도내용()));
  }

  static public String 가사영감을주시다(기도 기도){
    var rand = UniqueRandom.getInstance();
    return "새노래가사-"+rand.getRandomNumber(기도.get기도내용());
  }
}
