package dept;

public class 은하수 extends 부서 implements IDept{

  public 은하수(String 부서사명) {
    super(부서사명);
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }
}
