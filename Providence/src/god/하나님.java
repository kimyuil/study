package god;

import faith.기도;
import faith.말씀;

public class 하나님 {

  static public 말씀 말씀을주시다(기도 기도){
    var rand = UniqueRandom.getInstance();
    return new 말씀("깊고 웅장한 하나님의 시대 말씀-"+rand.getRandomNumber(기도.get기도내용()));
  }

  static public String 음악영감을주시다(기도 기도){
    var rand = UniqueRandom.getInstance();
    return "새노래음악-"+rand.getRandomNumber(기도.get기도내용());
  }
}
