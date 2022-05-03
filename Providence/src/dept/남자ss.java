package dept;

public class 남자ss extends 부서 implements IDept{

  public 남자ss(String 부서사명) {
    super(부서사명);
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }
}
