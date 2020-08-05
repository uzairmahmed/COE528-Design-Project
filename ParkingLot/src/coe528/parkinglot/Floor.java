package coe528.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author uzair
 */
public class Floor {
    public ArrayList<ArrayList <Space>> spaces;
    public int id ;
    public int[] floorCapacity;
    public int[] availableFloorCapacity;
    public Map<String, Integer> map = new HashMap<>();

    /**
     *
     * @param i
     * @param largeSlots
     * @param handicapSlots
     * @param i2
     * @param motorcycleSlots
     * @param i3
     * @param i4
     * @param EVSlots
     */
    public Floor(int compactSlots, int largeSlots, int handicapSlots, int motorcycleSlots, int EVSlots) {
        this.id = Lot.getInstance().numFloors+1;
        Lot.getInstance().numFloors++;
        Lot.getInstance().floors.add(this);
        
        this.spaces = new ArrayList<>();
        this.spaces.add(new ArrayList<>());
        this.spaces.add(new ArrayList<>());
        this.spaces.add(new ArrayList<>());
        this.spaces.add(new ArrayList<>());
        this.spaces.add(new ArrayList<>());        
        
        this.floorCapacity = new int[5];
        this.availableFloorCapacity = new int[5];
        
        map.put("compact", 0);
        map.put("large", 1);
        map.put("handicap", 2);
        map.put("motorcycle", 3);
        map.put("electric", 4);
        
        
        for(int i = 0; i < compactSlots; i++){
            createSpace("compact");
        }
        for(int i = 0; i < largeSlots; i++){
            createSpace("large");
        }   
        for(int i = 0; i < handicapSlots; i++){
            createSpace("handicap");
        }           
        for(int i = 0; i < motorcycleSlots; i++){
            createSpace("motorcycle");
        }                   
        for(int i = 0; i < EVSlots; i++){
            createSpace("electric");
        }
        
        System.out.println("Created Floor " + String.valueOf(this.id)+ ", Capacity:" + this.arrayToString(floorCapacity) + " TOTAL CAPACITY: " + getTotalFloorCapacity());
    }
    
    /**
     *
     * @param type
     */
    public void createSpace(String type){
        if (type.equals("electric")){
            new EVSpace("electric", this);
        } else {
            new Space(type, this);
        }
    }
    
    /**
     *
     * @return
     */
    public int[] getFloorCapacity() {
        return floorCapacity;
    }
    
    /**
     *
     * @return
     */
    public int getTotalFloorCapacity() {
        int capacity = 0;
        for (int cap : getFloorCapacity()){
            capacity += cap;
        }
        return capacity;
    }
    
    /**
     *
     * @return
     */
    public int getTotalAvailableFloorCapacity() {
        int capacity = 0;
        for (int cap : getAvailableFloorCapacity()){
            capacity += cap;
        }
        return capacity;
    }

    /**
     *
     * @return
     */
    public int[] getAvailableFloorCapacity() {
        for (ArrayList<Space> t:spaces){
            for(Space s : t){
                if (s.isFull()){
                    availableFloorCapacity[map.get(s.type)]--;
                }
            }
        }
        return availableFloorCapacity;
    }

    /**
     *
     * @param type
     * @return
     */
    public ArrayList<Space> getSpaces(String type) {
        ArrayList<Space> temp = spaces.get(map.get(type));
        return temp;
    }
    
    /**
     *
     * @param arr
     * @return
     */
    public String arrayToString(int[] arr){
        String txt = "[";
        for (int i : arr){
            txt += String.valueOf(i)+",";
        }
        txt += "]";
        return txt;
    }
}
