package dept;

public class 장년부 extends 부서 implements IDept{

  public 장년부(String 부서사명) {
    super(부서사명);
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }
}
