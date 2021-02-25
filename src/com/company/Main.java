package com.company;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
public static boolean TESTERS = false;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0",new DecimalFormatSymbols(new Locale("pt", "BR")));
        System.out.println("Starting Simulation of Mission to Mars! ");
        Simulation mission = new Simulation();


        if (Main.TESTERS) {
            System.out.println("Phase 1: U1 Rockets\n");

        }
        ArrayList<Item> u1Phase1 = mission.loadItems("FirstMission.txt");
        ArrayList<Rocket> u1Rockets = mission.loadRocketU1(u1Phase1);
        int u1Phase1Cost = mission.runSimulation(u1Rockets);


        if (Main.TESTERS) {
            System.out.println("Phase 2: U1 Rockets\n");

        }
        ArrayList<Item> u1Phase2 = mission.loadItems("SecondMission.txt");
        u1Rockets = mission.loadRocketU1(u1Phase2);
        int u1Phase2Cost = mission.runSimulation(u1Rockets);


        if (Main.TESTERS) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nPhase 1: U2 Rockets\n");
        }
        ArrayList<Item> u2Phase1 = mission.loadItems("FirstMission.txt");
        ArrayList<Rocket> u2Rockets = mission.loadRocketU2(u2Phase1);
        int u2Phase1Cost = mission.runSimulation(u2Rockets);


        if (Main.TESTERS) {
            System.out.println("Phase 2: U2 Rockets\n");
        }
        ArrayList<Item> u2Phase2 = mission.loadItems("SecondMission.txt");
        u2Rockets = mission.loadRocketU2(u2Phase2);
        int u2Phase2Cost = mission.runSimulation(u2Rockets);

        System.out.println("Simulation Results:\n");



        System.out.println("Phase 1 with U1: $" + df.format(u1Phase1Cost));
        System.out.println("Phase 2 with U1: $" + df.format(u1Phase2Cost));
        System.out.println("Total with U1: $" + df.format((u1Phase1Cost + u1Phase2Cost)));


        System.out.println();


        System.out.println("Phase 1 with U2: $" + df.format(u2Phase1Cost));
        System.out.println("Phase 2 with U2: $" + df.format(u2Phase2Cost));
        System.out.println("Total with U2: $" + df.format((u2Phase1Cost + u2Phase2Cost)));
    }
}

