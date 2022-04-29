package mike;

// 인도자가 잡는 마이크
public class SpreadMike extends SingMike {

    @Override
    public void speak(String script) {
        System.out.println("크게 울리는 소리로");
        super.speak(script);
    }
}
