package person;

import church.IChurch;
import dept.IDept;
import faith.말씀;
import person.mission.I평신도;

import java.util.List;

public class 평신도 extends Person implements I평신도 {

  public int 신앙정도;

  public 평신도(String name, IChurch 교회, List<IDept> 부서들, int 신앙정도) {
    super(name, 교회, 부서들);
    this.신앙정도 = 신앙정도;
  }

  public static 평신도 of(String name, IChurch 교회, List<IDept> 부서들, int 신앙정도){
    return new 평신도(name, 교회, 부서들, 신앙정도);
  }

  @Override
  public void 말씀을듣다(말씀 말씀) {
    if(신앙정도 < 0){
      System.out.println(이름 + " : "+말씀.get말씀내용()+" 잘 안듣습니다.");
    }else if(신앙정도 == 0){
      System.out.println(이름 + " : "+말씀.get말씀내용()+" 그냥 듣습니다.");
    }else if(신앙정도 < 10){
      System.out.println(이름 + " : "+말씀.get말씀내용()+" 잘 듣습니다.");
    }else if(신앙정도 < 20){
      System.out.println(이름 + " : "+말씀.get말씀내용()+" 열심히 듣습니다.");
    }else{
      System.out.println(이름 + " : "+말씀.get말씀내용()+" 깊이있게 듣습니다.");
    }
  }

  @Override
  public String get이름() {
    return 이름;
  }
}
