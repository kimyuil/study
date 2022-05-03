package dept;

public interface IDept {
  default String get부서이름() {
    return this.getClass().getSimpleName();
  }
  String get부서사명();
}
