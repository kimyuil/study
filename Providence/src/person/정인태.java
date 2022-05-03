package person;

import church.IChurch;
import dept.IDept;
import faith.말씀;
import mission.I목회자;
import mission.I지도자;
import mission.I평신도;

import java.util.List;

public class 정인태 extends Person implements I목회자 {


  public 정인태(String name, IChurch 교회, List<IDept> 부서들) {
    super(name, 교회, 부서들);
  }

  @Override
  public void 평신도관리(I평신도 p, 말씀 w) {
    System.out.println(이름 + " : 평신도를 관리합니다.");
    p.말씀을듣다(w);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    System.out.println(이름 + " : "+말씀.get말씀내용()+" 깊게 듣습니다.");
  }

  @Override
  public 말씀 말씀을전하다(말씀 말씀) {
    System.out.println(이름 + " : 말씀을 전합니다.");
    return 말씀;
  }

  @Override
  public void 지도자교육(말씀 말씀, List<I지도자> 지도자들) {
    System.out.println(이름 + " : 지도자 교육을 진행합니다.");
    for(var 지도자 : 지도자들){
      지도자.말씀을듣다(말씀);
    }
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
