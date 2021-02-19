package com.practice;

/*Implement the list of cities to visit using
1. Linkedlists
2. Iterative concept instead for loops or enhaced for loops
* it should have the following functionalities
* 0 quit
* 1 go to next city
* 2 go to prev city
* 3 print menu options
* */

import java.util.*;

public class Main {
    public Scanner userChoise = new Scanner(System.in);
    public LinkedList<String> linkedList = new LinkedList<>();


    public static void main(String[] args) {
        Main traveler1 = new Main();
        traveler1.loadToList(traveler1.linkedList);
        alphibaticallyAdd(traveler1.linkedList, "b");
        alphibaticallyAdd(traveler1.linkedList, "a");
        traveler1.printCities(traveler1.linkedList);

    }


    private static void loadToList(LinkedList<String> linkedList) {
        alphibaticallyAdd(linkedList, "Poznan");
        alphibaticallyAdd(linkedList, "Gdansk");
        alphibaticallyAdd(linkedList, "Szczeczin");
        alphibaticallyAdd(linkedList, "Warszawa");
        alphibaticallyAdd(linkedList, "Lodz");
        alphibaticallyAdd(linkedList, "Wroclaw");
    }

    private static void printCities(LinkedList<String> city) {
        Iterator<String> iterator = city.iterator(); //to print cities we only need an iterator instead listiterator!
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next());
            i++;
        }
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
}


