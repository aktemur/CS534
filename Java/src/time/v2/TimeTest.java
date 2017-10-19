package time.v2;

public class TimeTest {
    public static void main(String[] args) {
        Time t1 = new Time();
        t1.setTime(19, 58, 34);

        System.out.println(t1.toUniversalString());
        System.out.println(t1.toString());
    }
}
