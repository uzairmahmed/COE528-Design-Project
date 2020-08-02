package coe528.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author uzair
 */
public class Floor {
    public ArrayList<Space> spaces = new ArrayList();
    
    public int id ;
    public int[] floorCapacity;
    public int[] availableFloorCapacity;
    
    public Map<String, Integer> map = new HashMap<String, Integer>();

    public Floor(int compactSlots, int largeSlots, int handicapSlots, int motorcycleSlots, int EVSlots) {
        this.id = Lot.getInstance().numFloors+1;
        Lot.getInstance().numFloors++;
        Lot.getInstance().floors.add(this);
        
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
    }
    
    public void createSpace(String type){
        if (type.equals("electric")){
            new EVSpace("electric", this);
        } else {
            new Space(type, this);
        }
    }
    
    public int[] getFloorCapacity() {
        return floorCapacity;
    }
    
    public int getTotalFloorCapacity() {
        return floorCapacity[0];
    }

    public int[] getAvailableFloorCapacity() {
        return availableFloorCapacity;
    }

    public void setAvailableFloorCapacity(int[] availableFloorCapacity) {
        this.availableFloorCapacity = availableFloorCapacity;
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }
    
    
}
