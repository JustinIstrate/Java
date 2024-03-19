package org.example;

public class Person {

    private String personName;
    private int personAge;
    private String destination;

    private Boolean isDriver;

    public Person(String personName, int personAge, String destination, Boolean isDriver) {
        this.personName = personName;
        this.personAge = personAge;
        this.destination = destination;
        this.isDriver = isDriver;
    }

    public String getPersonName() {
        return personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public String getDestination() {
        return destination;
    }

    public Boolean isDriver() {
        return isDriver;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + personName + '\'' +
                ", Age=" + personAge +
                ", Destination='" + destination + '\'' +
                ", isDriver=" + isDriver +
                '}';
    }
}
