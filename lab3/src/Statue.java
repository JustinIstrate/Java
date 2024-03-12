import java.time.LocalTime;
import java.util.Arrays;

public class Statue extends Attraction implements Visitable{
    public Statue(String name, String description,String image,String[] days,String hours){
        super(name,description,image,days,hours);
    }
    @Override
    public String[] getOpenDays(){
        return this.openDays;
    }
    @Override
    public String getOpenHours(){
        return this.openHours;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", image='" + image + '\'' +
                ", openDays=" + Arrays.toString(openDays) +
                ", openHours='" + openHours + '\'' +
                ", fee=" + fee +
                '}'+'\n';
    }
}
