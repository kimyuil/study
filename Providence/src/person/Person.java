package person;

import church.IChurch;
import dept.IDept;

import java.util.List;

public class Person {
  String 이름;
  IChurch 교회;
  List<IDept> 부서들;

  public Person(String name, IChurch 교회, List<IDept> 부서들){
    this.이름=name;
    this.교회=교회;
    this.부서들=부서들;
  }

  public void 자기소개(){
    System.out.println(이름);
    System.out.println((교회 == null)?"교회소속이 없습니다.":교회.get교회이름()+" 다니고있습니다");
    if(부서들 == null || 부서들.size() == 0){
      System.out.println("부서 소속이 없습니다.");
    }else{
      System.out.println("총 "+부서들.size()+"개 부서를 뛰고있습니다.");
      for(var 부서 : 부서들){
        System.out.println(부서.get부서이름()+" 소속입니다. "+
            ((부서.get부서사명() == null) ? "" : 부서.get부서사명()+" 사명을 맡고 있습니다."));
      }
    }
  }
}
