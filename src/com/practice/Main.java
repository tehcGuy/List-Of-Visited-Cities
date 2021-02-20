package com.practice;

/*Implement the list of cities to visit using (finished)
1. Linkedlists
2. Iterative concept instead for loops or enhaced for loops
3. methods that are in menu
*
Possible ways to improve
Refactor in such way that:
1. Encapsulation holds
2. No spaghetti code
3. Handling ConcurrentModificationException in a differenet way
    1. Placing the navigate content into main method
4. Organnization in the classes does not make sense

IT IS NOT AN EXEMPLERY CODE!!!
the only take awaus from this project:
1. iterative object implementations
2. Methods: removeCity, alphibaticallyAdd, loadToList
3. Traveler class
*/

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List summerPlan = new List("Max", 20, "My best vacation!");
        summerPlan.getAccessToMain().navigate(summerPlan.getLinkedList());
    }


    public static void printCities(LinkedList<String> city) {
        Iterator<String> iterator = city.iterator(); //to print cities we only need an iterator instead listiterator!
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next());
            i++;
        }
    }

    public static void menu() {
        System.out.println("Please enter a digit to select one of the following options:");
        System.out.println("0 -> stop program");
        System.out.println("1 -> visit next city");
        System.out.println("2 -> visit prev city");
        System.out.println("3 -> print all cities from your list");
        System.out.println("4 -> print this menu");
        System.out.println("5 -> add a city");
        System.out.println("6 -> removing a city");
        System.out.println("7 -> printing out the amount of visited cities");

        System.out.println("9 -> load the default cities to visit to the list");
    }

    void navigate(LinkedList<String> listOfCities) {
        Scanner userChoice = new Scanner(System.in);
        List travelListObject = new List("", 0, "");

//        List traveler1 = new ...;
        ListIterator<String> listIterator = listOfCities.listIterator();
        boolean goingForward = true;
        boolean exit = false;

        while(!exit) {
            Main.menu();
            int choice = userChoice.nextInt();
            userChoice.nextLine(); //takes care of enter key problem
            switch(choice) {
                case 0:
                    exit = true;
                    System.out.println("Goodbye");
                    break;
                case 1: //moving forward
                    if(goingForward == false) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println(listIterator.next());
                        Traveler.setNumberVisitedCities(Traveler.getNumberVisitedCities() + 1);
                        goingForward = true;
                    } else {
                        System.out.println("No more cities in the list");
                        goingForward = false;
                    }
                    break;
                case 2: //moving back
                    if(goingForward == true) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        Traveler.setNumberVisitedCities(Traveler.getNumberVisitedCities() + 1);
                        System.out.println(listIterator.previous());
                    } else {
                        System.out.println("You're at the beggining of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    Main.printCities(listOfCities);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Write new city");
                    String addedCity = userChoice.next();
                    travelListObject.noExceptionError(listOfCities, addedCity);
                    break;
                case 6:
                    System.out.println("Write the city you want to delete");
                    String deletedCity = userChoice.next();
                    travelListObject.removeCity(listOfCities, deletedCity);
                    break;
                case 7:
                    System.out.println("You have been in " + Traveler.getNumberVisitedCities() + " cities in total");
                    break;
                case 9:
                    travelListObject.loadToList(listOfCities);
                    break;
                default:
                    System.out.println("Something weird happened. Try to choose an option again");
            }
        }
    }
}


