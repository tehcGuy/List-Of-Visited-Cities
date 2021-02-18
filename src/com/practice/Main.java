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
    public ArrayList<String> linkedList = new ArrayList<>();


    public static void main(String[] args) {
        Main traveler1 = new Main();
        traveler1.loadToList(traveler1.linkedList);
        traveler1.printCities(traveler1.linkedList);

        boolean exit = false;
        while(!exit){
            System.out.println("Please enter a digit to choose an option: ");
            int choice = traveler1.userChoise.nextInt();

            switch(choice){
                case 0:
                    exit = true;
                    break;
                case 1:
                    traveler1.nextCity(traveler1.linkedList);
                case 2:
                    traveler1.prevCity(traveler1.linkedList);
                case 3:

                case 4:
                    break;
            }
        }
    }

    private static void menu() {
        System.out.println("Please enter a digit to select one of the following options:");
        System.out.println("0 -> quit");
        System.out.println("1 -> visit next city");
        System.out.println("2 -> visit prev city");
        System.out.println("3 -> print all cities from your list");
        System.out.println("4 -> print this menu");
        System.out.println("9 -> load the default cities to visit to the list");
    }

    private static void loadToList(ArrayList<String> city) {
        city.add("Poznan");
        city.add("Gdansk");
        city.add("Szczeczin");
        city.add("Warszawa");
        city.add("Lodz");
        city.add("Wroclaw");
    }

    private void printCities(ArrayList<String> city) {
        ListIterator<String> iterator = city.listIterator();
        int i = 1;
        while(iterator.hasNext()) {
            System.out.println(i + ". " + iterator.next());
            i++;
        }
    }

//    here should be the function that shows that alphabetically adds Srting city name to the list

    //    here should be the function that goes next to alphibetical ordered city
    private void nextCity(ArrayList<String> city) {
        ListIterator<String> iterator = city.listIterator();
        System.out.println("You are in " + iterator.next());
    }

    private void prevCity(ArrayList<String> city) {
        ListIterator<String> iterator = city.listIterator();
        System.out.println("You are in " + iterator.previous());
    }


//    here should be the function that goes back to alphibetical ordered city

}

/* WORKS
        ListIterator<String> iterator = linkedList.listIterator();
        int i = 1;
        while(iterator.hasNext()){
            System.out.println(i +". "+iterator.next());
            i++;
        }
it is equivalent to
System.out.println(linkedList);


*/