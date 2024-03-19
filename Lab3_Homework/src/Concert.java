import java.util.*;
import java.time.LocalTime;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<String, TimeInterval> visitingTimetable;
    private double entryFee;

    public Concert(String name, String description, String image, double fee) {
        super(name, description, image);
        this.entryFee = fee;
        visitingTimetable = new HashMap<>();
        visitingTimetable.put("2024-03-15", new TimeInterval(LocalTime.of(20, 0), LocalTime.of(22, 0)));
    }

    @Override
    public double getEntryFee() {
        return this.fee;
    }
    @Override
    public Map<String, TimeInterval> getVisitingTimetable() {
        return visitingTimetable;
    }
    @Override
    public String toString() {
        return "Concert{" +
                "visitingTimetable=" + visitingTimetable +
                ", entryFee=" + entryFee +
                ", attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", image='" + image + '\'' +
                ", fee=" + fee +
                '}';
    }
}
