//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Trip trip=new Trip("San-Francisco","May 2024");
        Statue statue=new Statue("Statue of San-Francisco","very big very nice","image.jpg");
        Church church=new Church("Church of Catholics","nice","image");
        Concert concert=new Concert("Untold","a lot of big artists coming","image",150.0);

        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        trip.displayVisitableNotPayable();

        TravelPlan travelPlan= new TravelPlan();
        travelPlan.addVisit("2024-03-08",statue);
        travelPlan.addVisit("2024-03-12",church);
        travelPlan.addVisit("2024-03-15",concert);

        travelPlan.printTravelPlan();
    }
}