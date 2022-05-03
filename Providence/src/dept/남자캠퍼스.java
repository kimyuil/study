package dept;

public class 남자캠퍼스 extends 부서 implements IDept{

  public 남자캠퍼스(String 부서사명) {
    super(부서사명);
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }
}
