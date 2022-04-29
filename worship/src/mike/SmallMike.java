package mike;

// 싱어가 잡는 작은소리 마이크
public class SmallMike extends SingMike {
    @Override
    public void speak(String script) {
        System.out.println("약간 작은소리로");
        super.speak(script);
    }
}
