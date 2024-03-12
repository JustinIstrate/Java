abstract class Attraction implements Comparable<Attraction> {
        protected String attractionName;
        protected String attractionDescription;
        protected String image;
        protected String[] openDays;
        protected String openHours;
        protected double fee=0;

    public Attraction(String attractionName, String attractionDescription, String image, String[] openDays, String openHours) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.image = image;
        this.openDays = openDays;
        this.openHours = openHours;
    }
    public Attraction(String attractionName, String attractionDescription, String image, String[] openDays, String openHours,double fee) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.image = image;
        this.openDays = openDays;
        this.openHours = openHours;
        this.fee=fee;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public String getImage() {
        return image;
    }
    @Override
    public int compareTo(Attraction otherAttraction){
        return this.attractionName.compareTo(otherAttraction.attractionName);
    }
}
