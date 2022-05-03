package person;

import church.IChurch;
import dept.IDept;
import faith.기도;
import faith.말씀;
import faith.찬양;
import god.성령님;
import god.하나님;
import mission.*;

import java.util.List;

public class 선생님 extends Person implements I메시야 {

  public 선생님(String name, IChurch 교회, List<IDept> 부서들) {
    super(name, 교회, 부서들);
  }

  @Override
  public void 평신도관리(I평신도 평신도, 말씀 말씀) {
    System.out.println(이름 + " : 평신도를 말씀으로 관리해 주십니다.");
    평신도.말씀을듣다(말씀);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    System.out.println(이름 + " : "+말씀.get말씀내용()+" 누구보다 깊이 듣습니다.");
  }

  @Override
  public void 기도하다(기도 기도) {
    System.out.println(이름 + " : 1초도 어기지 않고 섭리와 우리를 위해 깊이 기도하십니다.");
  }

  @Override
  public 말씀 하나님께말씀을받다(기도 기도) {
    System.out.println(이름 + " : 말씀을 받기위해 하나님께 깊이 기도하십니다. " + 기도.get기도내용());
    return new 말씀(하나님.말씀을주시다(기도).get말씀내용());
  }

  @Override
  public 말씀 성령님께말씀을받다(기도 기도) {
    System.out.println(이름 + " : 말씀을 받기위해 성령님께 깊이 기도하십니다. " + 기도.get기도내용());
    return new 말씀(성령님.말씀을주시다(기도).get말씀내용());
  }

  @Override
  public 말씀 말씀을_권위있게_전하다(말씀 말씀) {
    System.out.println(이름 + " : 말씀을 메시야의 권세로 권위있게 전하십니다!");
    return 말씀;
  }

  @Override
  public 말씀 말씀을_뜨겁게_전하다(말씀 말씀) {
    System.out.println(이름 + " : 뜨겁게 성령으로 말씀을 전하십니다.");
    return 말씀;
  }

  @Override
  public 말씀 말씀을전하다(말씀 말씀) {
    System.out.println(이름 + " : 말씀을 전하십니다.");
    return 말씀;
  }

  @Override
  public 찬양 새노래작사작곡(기도 기도) {
    System.out.println(이름 + " : 새노래를 받기 위해 기도하십니다." + 기도.get기도내용());
    return new 찬양(하나님.음악영감을주시다(기도), 성령님.가사영감을주시다(기도));
  }

  @Override
  public void 죄를회개시키다(기도 기도, Person person) {
    System.out.println(이름 + " : " + person.이름 +"의 죄를 회개시켜주십니다. 기도 : "+ 기도.get기도내용());
  }


  @Override
  public void 지도자교육(말씀 말씀, List<I지도자> 지도자들) {
    System.out.println(이름 + " : 지도자 교육을 직접 해주십니다.");
    for(var 지도자 : 지도자들){
      지도자.말씀을듣다(말씀);
    }
  }

  @Override
  public void 목회자교육(말씀 말씀, List<I목회자> 목회자들) {
    System.out.println(이름 + " : 목회자 교육을 직접 해주십니다.");
    for(var 목회자 : 목회자들){
      목회자.말씀을듣다(말씀);
    }
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
