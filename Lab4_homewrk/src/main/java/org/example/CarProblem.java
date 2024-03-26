package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.*;

public class CarProblem {
    private List<Person> persons;

    public CarProblem(int nrOfPersons) {
        this.persons = generateRandomPerson(nrOfPersons);
    }

    private List<Person> generateRandomPerson(int count) {
        Faker faker = new Faker();
        Random random = new Random();

        return IntStream.range(0, count)
                .mapToObj(i -> {
                    String name = faker.name().fullName();
                    int age = random.nextInt(80) + 10;
                    boolean isDriver = age > 19 && random.nextBoolean();
                    String destination = "Destination" + (random.nextInt(5) + 1);
                    return new Person(name, age, destination);
                })
                .collect(Collectors.toList());
    }

    public List<String> destinationOfDriver() {
        return persons.stream().filter(person -> person.getPersonAge() > 17).map(Person::getDestination).distinct().collect(Collectors.toList());
    }

    public Map<String, List<Person>> peopleAndDestinations() {
        return persons.stream().collect(Collectors.groupingBy(Person::getDestination));
    }

    public void ridesMatching() {
        Map<String, List<Person>> peopleDestinations = peopleAndDestinations();
        List<String> destinations = destinationOfDriver();

        for (String destination : destinations) {
            List<Person> people = peopleDestinations.getOrDefault(destination, new ArrayList<>());
            List<Person> drivers = people.stream().filter(Person::isDriver).collect(Collectors.toList());
            List<Person> passengers = people.stream().filter(person -> !person.isDriver()).collect(Collectors.toList());

            for (Person driver : drivers) {
                for (Person passenger : passengers) {
                    if (passenger.getDestination().equals(driver.getDestination())) {
                        System.out.println("Driver: " + driver.getPersonName() + " ==========> Passenger: " + passenger.getPersonName()+" Destination: "+passenger.getDestination());
                        passengers.remove(passenger);
                        break;
                    }
                }
            }
        }
    }


}
