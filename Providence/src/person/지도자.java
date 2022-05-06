package person;

import church.IChurch;
import dept.IDept;
import faith.말씀;
import person.mission.I지도자;
import person.mission.I평신도;

import java.util.List;

public class 지도자 extends Person implements I지도자 {


  public 지도자(String name, IChurch 교회, List<IDept> 부서들) {
    super(name, 교회, 부서들);
  }

  public static 지도자 of(String name, IChurch 교회, List<IDept> 부서들){
    return new 지도자(name, 교회, 부서들);
  }

  @Override
  public void 평신도관리(I평신도 p, 말씀 w) {
    System.out.println(이름 + " : "+p.get이름()+" 회원을 관리합니다.");
    p.말씀을듣다(w);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    System.out.println(이름 + " : "+말씀.get말씀내용()+" 열심히 듣습니다.");
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
