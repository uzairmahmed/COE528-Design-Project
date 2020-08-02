package coe528.parkinglot;

import java.util.ArrayList;

/**
 *
 * @author uzair
 */
public class Lot {
    Entrance entrance1;
    Exit exit1;
    Exit exit2;
    
    public int totalNumTickets;
    
    public int numFloors;
    public ArrayList<Floor> floors = new ArrayList();
    
    private static Lot instance = null;

    private Lot() {
        entrance1 = new Entrance();
        exit1 = new Exit();
        exit2 = new Exit();
        
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
        int capacity = 0;
        for (Floor f : floors){
            capacity += f.getTotalFloorCapacity();
        }
        return capacity;
    }
    
    public int getTotalAvailableCapacity() {
        int capacity = 0;
        for (Floor f : floors){
            capacity += f.getTotalAvailableFloorCapacity();
        }
        return capacity;
    }

    public int[] getCapacity() {
        int[] capacity = new int[5];
        
        for (Floor f : floors){
            int[] temp = f.getFloorCapacity();
            for (int i = 0; i < 5; i++){
                capacity[i] += temp [i];
            }
        }
        System.out.println("Created Lot,     Capacity:" + arrayToString(capacity) + " TOTAL CAPACITY: " + getTotalCapacity());
        return capacity;
    }
    
    public int[] getAvailableCapacity() {
        int[] capacity = new int[5];
        
        for (Floor f : floors){
            int[] temp = f.getAvailableFloorCapacity();
            for (int i = 0; i < 5; i++){
                capacity[i] += temp [i];
            }
        }
        System.out.println("Available Parking Spaces :" + arrayToString(capacity) + " TOTAL CAPACITY: " + getTotalAvailableCapacity());
        return capacity;
    }

    
    public static String arrayToString(int[] arr){
        String txt = "[";
        for (int i : arr){
            txt += String.valueOf(i)+",";
        }
        txt += "]";
        return txt;
    }
}
