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
        List<Map.Entry<String, Attraction>> sortedEntries = new ArrayList<>(travelPlan.entrySet());
        Collections.sort(sortedEntries, Comparator.comparing(Map.Entry::getKey));
        System.out.println("Travel Plan: ");
        for (Map.Entry<String, Attraction> entry : sortedEntries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getAttractionName());
        }
    }
}
