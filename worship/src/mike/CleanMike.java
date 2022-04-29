package mike;

// 소리가 깨끗한 마이크
public class CleanMike implements Mike {
    @Override
    public void speak(String script) {
        System.out.println("깨끗한 소리로 마이크소리");
        System.out.println(script);
    }
}
