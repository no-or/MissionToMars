package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Simulation sim = new Simulation();

        ArrayList<Item> items_p1 = new ArrayList<Item>();
        ArrayList<Item> items_p2 = new ArrayList<Item>();

        ArrayList<RocketU1> u1s_p1 = new ArrayList<RocketU1>();
        ArrayList<RocketU1> u1s_p2 = new ArrayList<RocketU1>();

        ArrayList<RocketU2> u2s_p1 = new ArrayList<RocketU2>();
        ArrayList<RocketU2> u2s_p2 = new ArrayList<RocketU2>();

        items_p1 = sim.loadItems("phase-1.txt");
        items_p2 = sim.loadItems("phase-2.txt");

        u1s_p1 = sim.loadU1(items_p1);
        u1s_p2 = sim.loadU1(items_p1);

        u2s_p1 = sim.loadU2(items_p1);
        u2s_p2 = sim.loadU2(items_p2);

        System.out.println("Total budget needed for U1 rockets loaded with phase 1 items is: " + sim.runSimulation_u1(u1s_p1));
       // System.out.println("Total budget needed for U1 rockets loaded with phase 2 items is: " + sim.runSimulation_u1(u2s_p2));

        System.out.println("Total budget needed for U2 rockets loaded with phase 1 items is: " + sim.runSimulation_u2(u2s_p2));
       // System.out.println("Total budget needed for U2 rockets loaded with phase 2 items is: " + sim.runSimulation_u2(u2s_p2));
    }
}
