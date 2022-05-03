package god;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//싱글턴
//새노래 영감들과 시대 말씀이 중복되지 않고 무한함을 표현
public class UniqueRandom {

  private final List<Integer> randoms = new ArrayList<>();

  private static final UniqueRandom instance = new UniqueRandom();
  private UniqueRandom(){}

  static public UniqueRandom getInstance(){
    return instance;
  }

  // 기도의 내용이 seed가 되도록.. ㅎㅎ
  public Integer getRandomNumber(String seedPray){
    Random rand = new Random(System.currentTimeMillis()+ seedPray.length());
    if(randoms == null || randoms.size()==0){
      var value = rand.nextInt();
      randoms.add(value);
      return value;
    }

    while (true){

      boolean isDup = false;

      var value = rand.nextInt();
      for(var i : randoms){
        if(value == i){
          isDup = true;
          break;
        }
      }

      if(!isDup){
        return value;
      }
    }

  }

}
