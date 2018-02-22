package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    /*this method loads all items from a text file and returns an ArrayList of Items*/
    ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        String readLine;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                Item item = new Item();
                readLine = scanner.nextLine();
                int i = readLine.indexOf('=');
                item.name = readLine.substring(0, i);
                item.weight = Integer.parseInt(readLine.substring(i + 1));
                itemArrayList.add(item);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return itemArrayList;
    }

    /*this method takes the ArrayList of Items returned from loadItems and starts
     creating U1 rockets. It first tries to fill up 1 rocket with as many items as possible
     before creating a new rocket object and filling that one until all items are loaded.
     The method then returns the ArrayList of those U1 rockets that are fully loaded.*/

    ArrayList <RocketU1> loadU1 (ArrayList <Item> items) {
        ArrayList <RocketU1> fleetU1 = new ArrayList<RocketU1>();      // create ArrayList object fleetU1

        int i = 0;
        while (i != items.size()){                                     // repeat until all items are loaded
            RocketU1 U1 = new RocketU1();                              // create a new U1 rocket
            while (U1.currentWeight <= U1.maxWeight) {                 // repeat until rocket full
                if (items.get(i).weight > U1.cargoLimit ) {            // item weight > cargo limit?
                    System.out.println("phase-1.txt item " + items.get(i).name
                            + " has weight=" + items.get(i).weight + " which is heavier than cargo limit of U1 rocket=" + U1.cargoLimit);
                    i++;
                }
                if (U1.canCarry(items.get(i))) {                        //  can carry item i ?
                    U1.carry(items.get(i));                             // update rocket current weight and cargo carried
                    i++;                                                // point next item to load
                    if (i >= items.size()) {
                        fleetU1.add(U1);                // add rocket U1 to the fleet
                        break;                          // all items from file phase-1.txt are loaded --> exit loop
                    }
                } else {                                        // if can not carry item (is almost full loaded):
                    fleetU1.add(U1);                // add rocket U1 to the fleet
                    break;
                }
            }
        }
        return fleetU1;      // The method should then return that ArrayList of those U1 rockets that are fully loaded.
    }

    /* this method does the same as method above but for RocketU2*/
    ArrayList <RocketU2> loadU2 (ArrayList <Item> items) {
        ArrayList <RocketU2> fleetU2 = new ArrayList<RocketU2>();      // create ArrayList object fleetU1

        int i = 0;
        while (i != items.size()){                                     // repeat until all items are loaded
            RocketU2 U2 = new RocketU2();                              // create a new U2 rocket
            while (U2.currentWeight <= U2.maxWeight) {                 // repeat until rocket full
                if (items.get(i).weight > U2.cargoLimit ) {            // item weight > cargo limit?
                    System.out.println("phase-1.txt item " + items.get(i).name
                            + " has weight=" + items.get(i).weight + " which is heavier than cargo limit of U2 rocket=" + U2.cargoLimit);
                    i++;
                }
                if (U2.canCarry(items.get(i))) {                        //  can carry item i ?
                    U2.carry(items.get(i));                             // update rocket current weight and cargo carried
                    i++;                                                // point next item to load
                    if (i >= items.size()) {
                        fleetU2.add(U2);                // add rocket U2 to the fleet
                        break;                          // all items from file phase-1.txt are loaded --> exit loop
                    }
                } else {                                        // if can not carry item (is almost full loaded):
                    fleetU2.add(U2);                // add rocket U1 to the fleet
                    break;
                }
            }
        }
        return fleetU2;      // The method should then return that ArrayList of those U2 rockets that are fully loaded.
    }


    /*
    this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList. Every time a rocket explodes
    or crashes (i.e if launch or land return false) it will have to send that rocket again. All while keeping track of the total budget required
    to send each rocket safely to Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones).
     */
    int runSimulation_u1(ArrayList<RocketU1> rockets){
        int i  = 0;
        int count = 0;

        while(i < rockets.size()) {
            /*if (!rockets.get(i).launch()) {
                count++;
                continue;
            }
            if (!rockets.get(i).land()) {
                count++;
                continue;
            }*/
            count++;
            i++;
        }
        return count*rockets.get(0).rocketCost;
    }

    int runSimulation_u2(ArrayList<RocketU2> rockets){
        int i  = 0;
        int count = 0;

        while(i < rockets.size()) {
            /*if (!rockets.get(i).launch()) {
                count++;
                continue;
            }
            if (!rockets.get(i).land()) {
                count++;
                continue;
            }*/
            count++;
            i++;
        }
        return count*rockets.get(0).rocketCost;
    }
}





