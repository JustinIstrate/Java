import java.time.LocalTime;
import java.util.*;
public interface Visitable {

    Map<String, TimeInterval> getVisitingTimetable();
    default LocalTime getOpeningHour(String date) {
        Map<String, TimeInterval> timetable = getVisitingTimetable();
        if (timetable.containsKey(date)) {
            return timetable.get(date).getKey();
        }
        return null;
    }
}
