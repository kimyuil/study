package dept;

public class 교역자단 extends 부서 implements IDept{

  public 교역자단(String 부서사명) {
    super(부서사명);
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }
}
