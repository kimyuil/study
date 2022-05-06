package person;

import church.IChurch;
import dept.IDept;
import faith.말씀;
import person.mission.I목회자;
import person.mission.I부흥강사;
import person.mission.I지도자;
import person.mission.I평신도;

import java.util.List;

public class 부흥강사 extends Person implements I부흥강사 {


  public 부흥강사(String name, IChurch 교회, List<IDept> 부서들) {
    super(name, 교회, 부서들);
  }

  public static 부흥강사 of(String name, IChurch 교회, List<IDept> 부서들){
    return new 부흥강사(name, 교회, 부서들);
  }

  @Override
  public void 평신도관리(I평신도 p, 말씀 w) {
    System.out.println(이름 + " : 평신도를 관리합니다.");
    p.말씀을듣다(w);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    System.out.println(이름 + " : "+말씀.get말씀내용()+" 뜨겁게 듣습니다.");
  }

  @Override
  public 말씀 말씀을전하다(말씀 말씀) {
    System.out.println(이름 + " : 말씀을 전합니다.");
    return 말씀;
  }

  @Override
  public void 지도자교육(말씀 w, List<I지도자> 지도자들) {

  }


  @Override
  public 말씀 말씀을_뜨겁게_전하다(말씀 말씀) {
    System.out.println(이름 + " : 뜨겁게 성령으로 말씀을 전합니다.");
    return 말씀;
  }

  @Override
  public void 목회자교육(말씀 말씀, List<I목회자> 목회자들){
    System.out.println(이름 + " : 목회자 교육을 초근초근히 진행합니다.");
    for(var 목회자 : 목회자들){
      목회자.말씀을듣다(말씀);
    }
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
