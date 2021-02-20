package com.practice;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class List extends Traveler {
    private LinkedList<String> linkedList;
    private String tripName;
    private Scanner userChoice = new Scanner(System.in);

    private Main accessToMain = new Main();

    public Main getAccessToMain() {
        return accessToMain;
    }

    public List(String travelerName, int travelerAge, String tripName) {
        super(travelerName, travelerAge);
        this.linkedList = linkedList;
        this.tripName = tripName;
        this.linkedList = new LinkedList<>();
    }

    public LinkedList<String> getLinkedList() {
        return linkedList;
    }

    public String getTravelName() {
        return tripName;
    }


     void removeCity(LinkedList<String> cityList, String deletedCity) {

        if(cityList.remove(deletedCity)) {
            System.out.println(deletedCity + " has been removed");
        }
        LinkedList<String> updatedList = cityList;
        accessToMain.navigate(updatedList);
    }

    //adds a new city and update the list without an error
    void noExceptionError(LinkedList<String> listOfCities, String cityName) {
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
        accessToMain.navigate(updatedList);
    }


     void loadToList(LinkedList<String> listOfCities) {
        alphibaticallyAdd(listOfCities, "Poznan");
        alphibaticallyAdd(listOfCities, "Gdansk");
        alphibaticallyAdd(listOfCities, "Szczeczin");
        alphibaticallyAdd(listOfCities, "Warszawa");
        alphibaticallyAdd(listOfCities, "Lodz");
        alphibaticallyAdd(listOfCities, "Wroclaw");
        LinkedList<String> updatedList = listOfCities;
        accessToMain.navigate(updatedList);
    }

    private boolean alphibaticallyAdd(LinkedList<String> listOfCities, String cityName) {
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
