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
    public boolean launch() {
        this.explodeChance = this.explosionRate * ((double)cargoWeight /(double)cargoLimit);
        System.out.println("explodeChance is :" + this.explodeChance);
        System.out.println(Math.random());
        System.out.println((this.explodeChance < Math.random()));
        return (this.explodeChance > Math.random());
    }

    //overriding the launch method to get the result based on the appropriate parameters
    public boolean land(){
        this.crashChance = this.crashRate * ((double)this.cargoWeight /(double)this.cargoLimit);
        System.out.println("crashChance is :" + this.crashChance);
        System.out.println(Math.random());
        System.out.println((this.crashChance < Math.random()));
        return (this.crashChance > this.random);
    }
}
