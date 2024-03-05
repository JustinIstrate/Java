enum clientType {
    REGULAR,
    PREMIUM
}

public class Client {
    String name;
    int startTime;
    int endTime;
    clientType type;

    public Client(String name, int startTime, int endTime, clientType type) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public clientType getType() {
        return type;
    }

    public void setType(clientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "client{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", type=" + type +
                '}';
    }
    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Client))
            return false;
        Client aux = (Client) obj;
        return (aux.name == name && aux.startTime == startTime && aux.endTime == endTime && aux.type == type);
    }*/
}
