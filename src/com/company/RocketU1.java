package com.company;

public class RocketU1 extends Rocket {

    RocketU1(){
        rocketCost = 60;        //60Millions
        maxWeight = 18000;     //18 tonnes
        rocketWeight = 10000;   //10 tonnes
        explosionRate = 0.05;   //5%
        crashRate = 0.01;       //1%
        cargoLimit = maxWeight - rocketWeight;
        currentWeight = rocketWeight;
    }

    //overriding the launch method to get the result based on the appropriate parameters
    @Override
    public boolean launch() {
        this.explodeChance = this.explosionRate * ((double)this.cargoWeight /(double)this.cargoLimit);
        return (this.explodeChance < this.random);
    }

    //overriding the launch method to get the result based on the appropriate parameters
    @Override
    public boolean land(){
        this.crashChance = this.crashRate * ((double)this.cargoWeight /(double)this.cargoLimit);
        return (this.crashChance < this.random);
    }
}
