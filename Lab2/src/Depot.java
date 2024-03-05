public class Depot {
    String depotName;

    public Depot(String depotName) {
        this.depotName = depotName;
    }

    public String getDepotName() {
        return depotName;
    }

    public void setDepotName(String depotName) {
        this.depotName = depotName;
    }

    @Override
    public String toString() {
        return "depot{" +
                "depotName='" + depotName + '\'' +
                '}';
    }
    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Depot))
            return false;
        Depot aux = (Depot) obj;
        return aux.depotName == obj;
    }*/
}
