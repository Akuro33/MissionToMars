package com.company;

public class U2 extends Rocket {

    private static int count = 0;
    private int id;
    public U2(){
        super(120000000,18000, 29000);
        count++;
        this.id=count;}
    @Override
    public boolean launch() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (4.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    /**
     * Determine if landing was successful.
     * @return true if landing is a success, false if landing fails.
     */
    @Override
    public boolean land() {
        int random = (int) (Math.random() * 100) + 1;
        return random > (8.0 * getCargoWeight() / (getMaxWeight() - getRocketWeight()));
    }

    /**
     * Returns the rocket ID number
     * @return the rocket ID number
     */
    public int getId() {
        return id;
    }
}