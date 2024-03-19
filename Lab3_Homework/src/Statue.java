import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction {

    private Map<String, TimeInterval> visitingTimetable;

    public Statue(String name, String description, String image) {
        super(name, description, image);
        visitingTimetable = new HashMap<>();
        visitingTimetable.put("2024-03-15", new TimeInterval(LocalTime.MIN, LocalTime.MAX));
    }
    @Override
    public Map<String, TimeInterval> getVisitingTimetable(){
        return visitingTimetable;
    }
    @Override
    public String toString() {
        return "Statue{" +
                "visitingTimetable=" + visitingTimetable +
                ", attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", image='" + image + '\'' +
                ", fee=" + fee +
                '}';
    }
}
