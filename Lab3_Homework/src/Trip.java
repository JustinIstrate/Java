import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
        Collections.sort(attractions);
    }

    public String getCityName() {

        return cityName;
    }

    public List<Attraction> getAttractions() {

        return attractions;
    }
    public void displayVisitableNotPayable(){
        List<Attraction> visitableNotPayable=new ArrayList<>();
        for(Attraction attraction : attractions){
            if(attraction instanceof Visitable && !(attraction instanceof Payable))
                visitableNotPayable.add(attraction);
        }
        visitableNotPayable.sort(Comparator.comparing(attraction -> ((Visitable) attraction).getOpeningHour("2024-03-15")));
        System.out.println("Visitable Non-Payable Locations:");
        for (Attraction attraction : visitableNotPayable) {
            System.out.println(attraction.getAttractionName() + " - Opening hour: " + ((Visitable) attraction).getOpeningHour("2024-03-15"));
        }
    }
    @Override
    public String toString() {
        return "Trip{" + "cityName='" + cityName + '\'' + ", periodOfTime='" + periodOfTime + '\'' + ", attractions=" + attractions + '}';
    }
}
