import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;
enum clientType {
    REGULAR,
    PREMIUM
}

public class Client implements Comparable<Client>{
    private String name;
    public LocalTime startTime;
    public LocalTime endTime;
    private clientType type;

    public Client(String name, LocalTime startTime, LocalTime endTime, clientType type) {
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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public clientType getType() {
        return type;
    }

    public void setType(clientType type) {
        this.type = type;
    }
    public long getVisitTime() {
        long time = (Duration.between(startTime, endTime)).toHours();
        return time;
    }
    @Override
    public int hashCode(){
        return Objects.hashCode(name);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof Client))
            return false;
        Client aux = (Client) obj;
        return (aux.name == name && aux.startTime == startTime && aux.endTime == endTime && aux.type == type);
    }
    @Override
    public int compareTo(Client otherClient) {
        return this.endTime.compareTo(otherClient.endTime);
    }
}
