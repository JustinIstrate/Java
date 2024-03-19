abstract class Attraction implements Comparable<Attraction>, Visitable {
    protected String attractionName;
    protected String attractionDescription;
    protected String image;
    protected double fee = 0;

    public Attraction(String attractionName, String attractionDescription, String image) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.image = image;
    }

    public Attraction(String attractionName, String attractionDescription, String image,double fee) {
        this.attractionName = attractionName;
        this.attractionDescription = attractionDescription;
        this.image = image;
        this.fee = fee;
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
    public int compareTo(Attraction otherAttraction) {
        return this.attractionName.compareTo(otherAttraction.attractionName);
    }
}
