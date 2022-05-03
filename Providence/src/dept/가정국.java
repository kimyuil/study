package dept;

public class 가정국 extends 부서 implements IDept{

  String 기수;

  public 가정국(String 부서사명, String 기수) {
    super(부서사명);
    this.기수 = 기수;
  }

  @Override
  public String get부서사명() {
    return 부서사명;
  }

  @Override
  public String get부서이름() {
    return this.getClass().getSimpleName() + " " + 기수;
  }
}
