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

    ArrayList<RocketU1> loadU1(ArrayList<Item> itemArrayList){
        ArrayList<RocketU1> rocketU1s = new ArrayList<RocketU1>();
        RocketU1 rocketU1_1 = new RocketU1();
        int loadedWeight = 0;
        int i = 0;

        //Assuming one item's weight is always less than the cargo limit
        do{
            loadedWeight += itemArrayList.remove(i).weight;
            i++;
        }while((rocketU1_1.cargoLimit < loadedWeight ) && (i != itemArrayList.size()));

        if(i == itemArrayList.size()){
            rocketU1s.add(rocketU1_1);
            return rocketU1s;
        }
        else{
            RocketU1 rocketU1_2 = new RocketU1();
            loadedWeight = 0;

            //Assuming one item's weight is always less than the cargo limit
            do{
                loadedWeight += itemArrayList.remove(i).weight;
                i++;
            }while((rocketU1_2.cargoLimit < loadedWeight ) && (i != itemArrayList.size()));
            rocketU1s.add(rocketU1_2);

            return rocketU1s;
        }
    }

    ArrayList<RocketU2> loadU2(ArrayList<Item> itemArrayList){
        ArrayList<RocketU2> rocketU2s = new ArrayList<RocketU2>();
        RocketU2 rocketU2_1 = new RocketU2();
        int loadedWeight = 0;
        int i = 0;

        //Assuming one item's weight is always less than the cargo limit
        do{
            loadedWeight += itemArrayList.remove(i).weight;
            i++;
        }while((rocketU2_1.cargoLimit < loadedWeight ) && (i != itemArrayList.size()));

        if(i == itemArrayList.size()){
            rocketU2s.add(rocketU2_1);
            return rocketU2s;
        }
        else{
            RocketU2 rocketU2_2 = new RocketU2();
            loadedWeight = 0;

            //Assuming one item's weight is always less than the cargo limit
            do{
                loadedWeight += itemArrayList.remove(i).weight;
                i++;
            }while((rocketU2_2.cargoLimit < loadedWeight ) && (i != itemArrayList.size()));
            rocketU2s.add(rocketU2_2);

            return rocketU2s;
        }
    }

    /*
    this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList. Every time a rocket explodes
    or crashes (i.e if launch or land return false) it will have to send that rocket again. All while keeping track of the total budget required
    to send each rocket safely to Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones).
     */
    int runSimulation_u1(ArrayList<RocketU1> rockets){
        boolean launch;
        boolean crash;
        int i  = 0;
        int count = 0;

        while(i < rockets.size()){
            while(!(rockets.get(i).launch()) || !(rockets.get(i).land())){
                count++;
            }
            count++; //for the successful launch and land
            i++;
        }
        return count*rockets.get(0).rocketCost;
    }

    int runSimulation_u2(ArrayList<RocketU2> rockets){
        boolean launch;
        boolean crash;
        int i  = 0;
        int count = 0;

        while(i < rockets.size()){
            while(!(rockets.get(i).launch()) || !(rockets.get(i).land())){
                count++;
            }
            count++; //for the successful launch and land
            i++;
        }
        return count*rockets.get(0).rocketCost;
    }
}





