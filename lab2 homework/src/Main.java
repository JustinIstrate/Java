import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
public class Main {
    public static void main(String[] args) {

        Depot dp1=new Depot("Audi");
        Depot dp2=new Depot("BMW");
        Truck v1=new Truck("Seria 3",dp1,10);
        Truck v2=new Truck("Seria 2",30);
        Drone dr1=new Drone("audi",dp2,10);
    }
}