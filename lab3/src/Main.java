//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Trip trip=new Trip("San-Francisco","May 2024");
        String[] arr={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Statue statue=new Statue("Statue of San-Francisco","very big very nice","image",arr,"all day");
        Church church=new Church("Church of Catholics","nice","image",arr,"From 8am to 9pm");
        Concert concert=new Concert("Untold","a lot of big artists coming","image",arr,"From 5pm to 2am next day",150);

        trip.addAttraction(statue);
        trip.addAttraction(church);
        trip.addAttraction(concert);

        System.out.println(trip);
    }
}