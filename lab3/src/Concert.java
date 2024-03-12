import java.util.Arrays;

public class Concert extends Attraction implements Visitable,Payable{
    public Concert(String name,String description,String image,String[] days,String hours,double fee){
        super(name,description,image,days,hours,fee);
    }
    @Override
    public String[] getOpenDays(){
        return openDays;
    }
    @Override
    public String getOpenHours(){
        return openHours;
    }
    @Override
    public double getEntryFee(){
        return this.fee;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "attractionName='" + attractionName + '\'' +
                ", attractionDescription='" + attractionDescription + '\'' +
                ", image='" + image + '\'' +
                ", openDays=" + Arrays.toString(openDays) +
                ", openHours='" + openHours + '\'' +
                ", fee=" + fee +
                '}'+'\n';
    }
}
