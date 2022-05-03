package person;

import church.IChurch;
import dept.IDept;
import faith.말씀;
import mission.I지도자;
import mission.I평신도;

import java.util.List;

public class 평신도1 extends Person implements I평신도 {


  public 평신도1(String name, IChurch 교회, List<IDept> 부서들) {
    super(name, 교회, 부서들);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    System.out.println(이름 + " : "+말씀.get말씀내용()+" 잘 듣습니다.");
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
