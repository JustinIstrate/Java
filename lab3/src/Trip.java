import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trip {
    private String cityName;
    private String periodOfTime;
    private List<Attraction> attractions;

    public Trip(String cityName, String periodOfTime) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = new ArrayList<>();
    }
    public void addAttraction(Attraction attraction)
    {
        attractions.add(attraction);
        Collections.sort(attractions);
    }

    public String getCityName() {
        return cityName;
    }

    public String getPeriodOfTime() {
        return periodOfTime;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", periodOfTime='" + periodOfTime + '\'' +
                ", attractions=" + attractions +
                '}';
    }
}
