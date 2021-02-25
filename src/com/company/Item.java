package com.company;

public class Item {
    private String name;
    private double weight;

    /**
     * @param name Nazwa przedmiotu
     * @param weight Jego waga
     */

    public Item(String name, double weight){
        this.name = name;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public double getWeight(){
        return weight;
    }


}
