package coe528.parkinglot;

import java.util.ArrayList;

/**
 *
 * @author uzair
 */
public class Lot {
    public int totalNumTickets;
    
    public int numFloors;
    public ArrayList<Floor> floors = new ArrayList();
    
    public int totalCapacity;
    public int availableCapacity;
    
    private static Lot instance = null;

    private Lot() {
        this.totalNumTickets = 0;  
        this.numFloors = 0;
    }

    public static Lot getInstance(){
        if (instance == null) instance = new Lot();
        return instance;
    }
    
    public void createFloor(int compactSlots, int largeSlots, int handicapSlots, int motorcycleSlots, int EVSlots){
        new Floor(compactSlots, largeSlots, handicapSlots, motorcycleSlots, EVSlots);
    }
    
    public int getNumFloors() {
        return numFloors;
    }
    
    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }
}
