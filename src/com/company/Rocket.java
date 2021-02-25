package com.company;
import java.util.ArrayList;


public class Rocket implements SpaceShip {
    private ArrayList<Item> items;
    private int cost;
    private double RocketWeight;
    private double MaxWeight;
    private int id;

    public Rocket(int cost, double WeightOfRocket, double MaxWeight) {
        items = new ArrayList<>();
        this.id = -1;
        this.cost = cost;
        this.RocketWeight = RocketWeight;
        this.MaxWeight = MaxWeight;
            }

    public int getCost(){
        return cost;
            }

    public double getRocketWeight() {
        return RocketWeight;
    }
    public double getMaxWeight (){
        return MaxWeight;
    }

    public int getId(){
        return id;
    }
    @Override
    public boolean launch() {
        return true;
    }
    @Override
    public boolean land() {
        return true;
    }
    @Override
    public boolean canCarry(Item item) {
        return (getCargoWeight() + item.getWeight()) <= (MaxWeight - RocketWeight);
    }
        @Override
        public void carry(Item item) {
            items.add(item);
        }

    public double getCargoWeight() {
        double cargoWeight = 0;
        for (Item cargoItem : items) {
            cargoWeight = cargoWeight + cargoItem.getWeight();
        }
        return cargoWeight;

    }






}
