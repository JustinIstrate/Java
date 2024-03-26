package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class CarSharing {
    private List<Person> persons;

    public CarSharing(int numberOfPersons) {
        this.persons = generateRandomPersons(numberOfPersons);
    }

    public LinkedList<Person> getDriversSortedByAge() {
        return persons.stream()
                .filter(persons-> persons.getPersonAge()>=20)
                .sorted(Comparator.comparingInt(Person::getPersonAge))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Set<Person> getPassengersSortedByName() {
        Comparator<Person> byNameComparator = Comparator.comparing(Person::getPersonName);
        return persons.stream()
                .filter(person -> person.getPersonAge()<20)
                .collect(Collectors.toCollection(() -> new TreeSet<>(byNameComparator)));
    }

    private List<Person> generateRandomPersons(int count) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        String[] names={"Maria","Ioan","Stefan","Anton","Dani sefu","Adrian","Gigel","Serby","John","Justin"};
        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)];
            int age = random.nextInt(70) + 10;
            boolean isDriver = random.nextBoolean();
            String destination = "Destination" + (random.nextInt(5) + 1);

            persons.add(new Person(name, age, destination,isDriver));
        }
        return persons;
    }
}
