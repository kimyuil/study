package mike;

// 싱어가 잡는 작은소리 마이크
public class SingMike implements Mike {

    @Override
    public void speak(String script) {
        System.out.println(script);
    }
}
