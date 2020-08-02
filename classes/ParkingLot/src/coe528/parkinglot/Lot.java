package coe528.parkinglot;

import java.util.ArrayList;

/**
 *
 * @author uzair
 */
public class Lot {
    public int numFloors;
    public ArrayList<Floor> floors = new ArrayList();
    
    public int totalCapacity;
    public int availableCapacity;

    private Lot() {
    }
    
    public static class LotHolder {
        private static final Lot INSTANCE = new Lot(); //Need to find a way to choose number of floors here
    }
    
    public static Lot getInstance(){
        return LotHolder.INSTANCE;
    }
    
    
    
    public void createFloor(int compactSlots, int largeSlots, int handicapSlots, int motorcycleSlots, int EVSlots){
        //Create a floor with these params.
    }
    
    

    public int getNumFloors() {
        return numFloors;
    }
    
    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int avaiableCapacity) {
        this.availableCapacity = avaiableCapacity;
    }
    
    

}
