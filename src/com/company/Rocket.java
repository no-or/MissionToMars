package com.company;

/*This class implements SpaceShip interface*/

import java.util.Random;
public class Rocket implements SpaceShip {

    int rocketCost;                   //The cost of the rocket
    int rocketWeight;                 //The weight of the rocket exluding cargo (in kg)
    int maxWeight;                    //Maximum weight(in kg) the rocket can carry including cargo
    int currentWeight;                //This field is for keeping tract of the current weight(in kg) of the rocket
    int cargoWeight;                  //Weight(in kg) of the cargo
    int cargoLimit;                   //Weight(in kg) limit for the cargo;
    //int rocketStatus;                   //-2 = exploded; 1 = launched; -1 = crashed; 0 = landed; 2= not loeaded; 3 = loaded;
    double explosionRate;             //explosion rate
    double crashRate;                 //crashing rate
    double explodeChance;               //chance of getting exploded while launching
    double crashChance;                 //chance of crashing while landing
    double random;

    Rocket(){
        rocketCost = 0;
        rocketWeight = 0;
        maxWeight = 0;
        currentWeight = 0;
        cargoWeight = 0;
        cargoLimit = 0;
        explosionRate = 0.0;
        crashRate = 0.0;
        explosionRate = 0.0;
        crashChance = 0.0;
        explodeChance = 0.0;
    }
    /*launch and land methods in the Rocket class always returns true.
      When U1 and U2 classes extend the Rocket class they will override these methods
      to return true or false based on the actual probability of each type.*/
    public boolean launch() {
        System.out.println("main_launch");
        return true;
    }

    public boolean land() {
        System.out.println("main_land");
        return true;
    }

    /*takes an item as the argument and returns true if the rocket can carry the item, otherwise returns false*/
    public boolean canCarry(Item item) {
        return  ((this.currentWeight + item.weight) <= this.maxWeight);
    }

    /*takes an item as the argument and updates the current weight of the rocket*/
    public void carry(Item item) {
        this.currentWeight = this.currentWeight + item.weight;
        this.cargoWeight = this.currentWeight - this.rocketWeight;
    }
}
