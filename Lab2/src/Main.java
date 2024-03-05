import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Depot depot = new Depot("Bavaria");
        Client cl1 = new Client("Marian", 6, 10, clientType.REGULAR);
        Client cl2 = new Client("Maria", 8, 11, clientType.REGULAR);
        Client cl3 = new Client("SEFU", 12, 14, clientType.PREMIUM);
        Vehicle car = new Vehicle("BMW", depot);

        List<Client> clients = new ArrayList<>();
        clients.add(cl1);
        clients.add(cl2);
        clients.add(cl3);
        car.setClients(clients);

        System.out.println(depot);
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(car);
        System.out.println(cl1.equals(cl2));
    }
}