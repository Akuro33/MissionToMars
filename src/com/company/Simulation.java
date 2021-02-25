package com.company;



import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Simulation {

    DecimalFormat df = new DecimalFormat("#,##0",new DecimalFormatSymbols(new Locale("pt", "BR")));

    public ArrayList<Item> loadItems(String filename){
        ArrayList<Item> items = new ArrayList<>();  // tworzy Kolekcje
        File file = new File(filename); // Zczytywanie pliku

        try {
            Scanner in = new Scanner(file); // Spisywanie Plików
            while (in.hasNextLine()){
                String line = in.nextLine();
                int index = line.indexOf("=");
                String name = line.substring(0, index);
                double weight = Double.parseDouble(line.substring(index + 1));
                Item item = new Item(name, weight);
                items.add(item);
            } // Uzupełnia Kolekcję, póki znajduję nową linię tekstu
        }catch (FileNotFoundException e){
            System.out.println("Error: File " + filename + "not found!");
        }
        return items;
    }

    public ArrayList<Rocket> loadRocketU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();


        while(items.size() > 0) {
            // create new U1
            U1 u1 = new U1();

            if (Main.TESTERS) {
                System.out.println("  LoadedU1 rocket #" + u1.getId()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }


            // uzupełnia u1 do pełna, później tworzy nową rakiete
            for (int i = items.size() - 1; i >= 0; i--) {
                if (u1.canCarry(items.get(i))) {
                    u1.carry(items.get(i));
                    if (Main.TESTERS) {
                        System.out.println("+" + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }


            rockets.add(u1);
            if (Main.TESTERS) {
               System.out.println("~~~~~~Total Cargo: " + df.format(u1.getCargoWeight())+"~~~~~~\n");
            }
        }

        return rockets;
    }

    public ArrayList<Rocket> loadRocketU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while(items.size() > 0) {

            U2 u2 = new U2();

            if (Main.TESTERS) {
                System.out.println(" Loading U2 rocket #" + u2.getId()+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              }


            for (int i = items.size() - 1; i >= 0; i--) {
                if (u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    if (Main.TESTERS) {
                        System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    }
                    items.remove(i);
                }
            }


            rockets.add(u2);
            if (Main.TESTERS) {
                System.out.println("~~~~~~Total Cargo: " + df.format(u2.getCargoWeight())+"~~~~~~\n");
                  }
        }

        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (int i = rockets.size() - 1; i >= 0; i--) {
            boolean launch;
            boolean land;
            do {
                totalCost = totalCost + rockets.get(i).getCost();
                launch = rockets.get(i).launch();
                land = rockets.get(i).land();
                if (Main.TESTERS) {
                    if (!launch) {
                        System.out.println("Rocket " + rockets.get(i).getId() + " exploded on launch! We try rebuild, and launch it Again!.");
                    } else {
                        System.out.print("  Rocket " + rockets.get(i).getId() + " successfully launched... ");
                        if (!land) {
                            System.out.println(" but crashed on landing! We will try rebuild and re-launched.");
                        } else {
                            System.out.println(" and landed.");
                        }
                    }

                }
            } while (!launch || !land);
            rockets.remove(i);
        }

        if (Main.TESTERS) {
            System.out.println("");
        }

        return totalCost;
    }
}