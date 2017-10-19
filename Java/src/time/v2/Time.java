package time.v2;

public class Time {
    private int seconds;

    public void setTime(int h, int m, int s) {
        // validate hour
        int hour = ((h >= 0 && h < 24) ? h : 0);
        // validate minute
        int minute = ((m >= 0 && m < 60) ? m : 0);
        // validate second
        int second = ((s >= 0 && s < 60) ? s : 0);

        seconds = hour * 60 * 60 + minute * 60 + second;
    }

    // convert to string in the form H:M:S
    public String toUniversalString() {
        int hour = seconds / 3600;
        int minute = (seconds / 60) % 60;
        int second = seconds % 60;

        return hour + ":" + minute + ":" + second;
    }

    // convert to string in the form H:M:S AM or PM
    public String toString() {
        int hour = seconds / 3600;
        int minute = (seconds / 60) % 60;
        int second = seconds % 60;
        
        return ((hour == 0 || hour == 12) ? 12 : hour % 12)
                            + ":" + minute
                            + ":" + second
            + " " + (hour < 12 ? "AM" : "PM");
    }
}



