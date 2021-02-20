package com.practice;

/*Implement the list of cities to visit using
1. Linkedlists
2. Iterative concept instead for loops or enhaced for loops
methods that are in menu
* */

import java.util.*;

public class Main {
    public Scanner userChoise = new Scanner(System.in);
    public LinkedList<String> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        Main traveler1 = new Main();
/*
        traveler1.loadToList(traveler1.linkedList);
        alphibaticallyAdd(traveler1.linkedList, "b");
        alphibaticallyAdd(traveler1.linkedList, "a");
        traveler1.printCities(traveler1.linkedList);
                Main.loadToList(traveler1.linkedList);

*/

        Main.navigate(traveler1.linkedList);
    }

    private static void navigate(LinkedList<String> listOfCities) {
        Scanner userChoice = new Scanner(System.in);
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
                    Main.noExceptionError(listOfCities, addedCity);
                    break;
                case 6:
                    System.out.println("Write the city you want to delete");
                    String deletedCity = userChoice.next();

                    removeCity(listOfCities, deletedCity);
                    break;
                case 9:
                    Main.loadToList(listOfCities);
                    break;
            }
        }
    }

    private static void removeCity(LinkedList<String> listOfCities, String cityName) {
        if(listOfCities.remove(cityName)) {
            System.out.println(cityName + " has been removed");
        }
        LinkedList<String> updatedList = listOfCities;
        Main.navigate(updatedList);
    }


    //adds a new city and update the list without an error
    private static void noExceptionError(LinkedList<String> listOfCities, String cityName) {
        ListIterator<String> listIterator = listOfCities.listIterator();

        while((listIterator.hasNext())) {
            int comparison = listIterator.next().compareTo(cityName);
            if(comparison == 0) {
                System.out.println(cityName + " has been already added to the list");
                return;
            } else if(comparison > 0) {
                listIterator.previous();
                break;
            }
        }
        listIterator.add(cityName);

        LinkedList<String> updatedList = listOfCities;
        Main.navigate(updatedList);
    }



    private static void printCities(LinkedList<String> city) {
        Iterator<String> iterator = city.iterator(); //to print cities we only need an iterator instead listiterator!
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next());
            i++;
        }
    }

    private static void menu() {
        System.out.println("Please enter a digit to select one of the following options:");
        System.out.println("0 -> stop program");
        System.out.println("1 -> visit next city");
        System.out.println("2 -> visit prev city");
        System.out.println("3 -> print all cities from your list");
        System.out.println("4 -> print this menu");
        System.out.println("5 -> add a city");
        System.out.println("6 -> removing a city");

        System.out.println("9 -> load the default cities to visit to the list");
    }
    private static void loadToList(LinkedList<String> listOfCities) {
        alphibaticallyAdd(listOfCities, "Poznan");
        alphibaticallyAdd(listOfCities, "Gdansk");
        alphibaticallyAdd(listOfCities, "Szczeczin");
        alphibaticallyAdd(listOfCities, "Warszawa");
        alphibaticallyAdd(listOfCities, "Lodz");
        alphibaticallyAdd(listOfCities, "Wroclaw");
        LinkedList<String> updatedList = listOfCities;
        Main.navigate(updatedList);
    }
    private static boolean alphibaticallyAdd(LinkedList<String> listOfCities, String cityName) {
        ListIterator<String> listIterator = listOfCities.listIterator(); //just a setup; doesn't point to the 1st element

        while((listIterator.hasNext())) {
            //if value is greater, the word that is in the list is alphabetically bigger, thus, put it before the list element
            //if equal, it is duplicate! return false
            // else it is less, thus, we have to move further in the list
            int comparison = listIterator.next().compareTo(cityName); //retrieves the 1st value and goes to the next
            if(comparison == 0) {
                System.out.println(cityName + " has been already added to the list");
                return false;
            } else if(comparison > 0) {
                listIterator.previous(); //because we've used .next() in the int comparison initialization
                listIterator.add(cityName); //dont use linkedList.add because it doesnt know the int comparison, so cannot properly add!!!
                return true;
            }

        }
        listIterator.add(cityName); //adding at the end of the list

        return true;
    }

}


