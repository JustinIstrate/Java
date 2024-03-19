import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> {
    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
    }
}
