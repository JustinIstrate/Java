import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    String vehicleName;
    Depot depotPlace;
    List<Client> clients;

    public Vehicle(String vehicleName, Depot depotPlace) {
        this.vehicleName = vehicleName;
        this.depotPlace = depotPlace;
        this.clients = new ArrayList<>();
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Depot getDepotPlace() {
        return depotPlace;
    }

    public void setDepotPlace(Depot depotPlace) {
        this.depotPlace = depotPlace;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "vehicle{" +
                "vehicleName='" + vehicleName + '\'' +
                ", depotPlace=" + depotPlace +
                ", clients=" + clients +
                '}';
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Vehicle))
            return false;
        Vehicle aux = (Vehicle) obj;
        return (aux.clients == clients && aux.vehicleName == vehicleName && aux.depotPlace == depotPlace);
    }*/
}