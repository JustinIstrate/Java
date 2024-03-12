import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Problem {
    //Vom avea array uri ce stocheaza depozitele, vehiculele si clientii
    public List<Depot> depots = new ArrayList<>();
    public List<Vehicle> vehicles = new ArrayList<>();
    public List<Client> clients =new ArrayList<>();
    ///////////////////////
    //Metoda pentru a adauga depozitele
    public void addDepot (Depot depot){
        if(!depots.contains(depot)){
            depots.add(depot);
        }
    }
    //Metoda de a adauga vehiclele
    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }
    // Metoda pentru a adauga clientii
    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }}

    // Metoda pentru a afisa toate vehiclele de la toate depozitele
    public Vehicle[] getVehicles() {
        Vehicle[] vehicleArray = new Vehicle[vehicles.size()];
        return vehicles.toArray(vehicleArray);
    }
    // Metoda de a afisa toate depozitele
    public Depot[] getDepots() {
        Depot[] depotsArray = new Depot[depots.size()];
        return depots.toArray(depotsArray);
    }

    //// Metoda de a afisa toti clientii
    public Client[] getClients() {
        Client[] clientsArray = new Client[clients.size()];
        return clients.toArray(clientsArray);

    }
    //Metoda pentru a sorta toti clientii in functie de visitEndTime
    public void sortClientsByEndTime() {
        Collections.sort(clients);
    }

    /*  Metoda pentu alocarea clientilor folosind un algoritm greedy (eu m-am gandit la algoritmul de Scheduling in care
     * sortam activitatile in functie de timpul de terminare ) asa facem si aici, sortam clientii dupa timpul de terminare
     * a vizitei, si apoi se aloca clientii la vehicule astfel: alocam clienti la un vehicul doar daca nu se intersecteaza
     * intervalul de timp de vizitare cu clientii care au fost deja alocati, si astfel se incearca alocarea tuturor
     * clientilor (pe cat este posibil).
     */
}