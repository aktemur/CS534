package time.v1;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public void setTime(int h, int m, int s) {
        // validate hour
        hour = ((h >= 0 && h < 24) ? h : 0);
        // validate minute
        minute = ((m >= 0 && m < 60) ? m : 0);
        // validate second
        second = ((s >= 0 && s < 60) ? s : 0);
    }

    // convert to string in the form H:M:S
    public String toUniversalString() {
        return hour + ":" + minute + ":" + second;
    }

    // convert to string in the form H:M:S AM or PM
    public String toString() {
        return ((hour == 0 || hour == 12) ? 12 : hour % 12)
                + ":" + minute
                + ":" + second
                + " " + (hour < 12 ? "AM" : "PM");
    }
}
