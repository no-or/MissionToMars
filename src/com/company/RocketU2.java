package com.company;

public class RocketU2 extends Rocket {

    RocketU2(){
        rocketCost = 120;        //120 Millions
        maxWeight = 29000;     //29 tonnes
        rocketWeight = 20000;   //20 tonnes
        explosionRate = 0.04;   //4%
        crashRate = 0.08;       //8%
        cargoLimit = maxWeight - rocketWeight;
        currentWeight = rocketWeight;
    }

    //overriding the launch method to get the result based on the appropriate parameters
    public boolean launch() {
        this.explodeChance = this.explosionRate * ((double)this.cargoWeight /(double)this.cargoLimit);
        System.out.println("U2_launch");
        return (this.explodeChance > Math.random());
    }

    //overriding the launch method to get the result based on the appropriate parameters
    public boolean land(){
        this.crashChance = this.crashRate * ((double)this.cargoWeight /(double)this.cargoLimit);
        System.out.println("U2_land");
        return (this.crashChance > this.random);
    }
}
