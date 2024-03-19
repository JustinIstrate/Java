import java.time.LocalTime;
import java.util.*;

public class Church extends Attraction implements Visitable{
    private Map<String,TimeInterval> visitingTimetable;
    public Church(String name,String description,String image){
        super(name,description,image);
        visitingTimetable=new HashMap<>();
        visitingTimetable.put("2024-03-15", new TimeInterval(LocalTime.of(9, 0), LocalTime.of(18, 0)));
    }
    @Override
    public Map<String,TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public String toString() {
        return "Church{" +
                "visitingTimetable=" + visitingTimetable +
                ", attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", image='" + image + '\'' +
                ", fee=" + fee +
                '}';
    }
}
