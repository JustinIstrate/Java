public class Depot {
    private String depotName;
    private Vehicle[] vehicles;
    public Depot depots;
    public Depot(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }
    public void setVehicles(Vehicle[] vehicles){
        this.vehicles=vehicles;
        for( Vehicle v : vehicles){
            v.setVehicleDepot(this);
        }
    }
    @Override
    public String toString() {
        return "depot{" +
                "depotName='" + depotName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Depot))
            return false;
        Depot aux = (Depot) obj;
        return aux.depotName == obj;
    }
}
