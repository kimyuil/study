package church;

public interface IChurch {
  default String get교회이름() {
    return this.getClass().getSimpleName();
  }
  String get지역();
}
