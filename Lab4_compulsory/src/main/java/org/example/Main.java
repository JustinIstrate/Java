package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        CarSharing carpoolProblem = new CarSharing(10);

        LinkedList<Person> driversSortedByAge = carpoolProblem.getDriversSortedByAge();
        System.out.println("Drivers sorted by age:");
        driversSortedByAge.forEach(System.out::println);

        TreeSet<Person> passengersSortedByName = carpoolProblem.getPassengersSortedByName();
        System.out.println("\nPassengers sorted by name:");
        passengersSortedByName.forEach(System.out::println);
    }
}