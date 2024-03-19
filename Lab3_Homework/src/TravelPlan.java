import java.util.*;

public class TravelPlan {
    private Map<String, Attraction> travelPlan;

    public TravelPlan() {
        travelPlan = new HashMap<>();
    }

    public void addVisit(String date, Attraction attraction) {
        travelPlan.put(date, attraction);
    }

    public Map<String, Attraction> getTravelPlan() {
        return travelPlan;
    }

    public void printTravelPlan() {
        System.out.println("Travel Plan: ");
        for (Map.Entry<String, Attraction> entry : travelPlan.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getAttractionName());
        }
    }
}
