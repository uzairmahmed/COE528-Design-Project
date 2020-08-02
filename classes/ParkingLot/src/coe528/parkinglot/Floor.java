package coe528.parkinglot;

import java.util.ArrayList;

/**
 *
 * @author uzair
 */
public class Floor {
    public ArrayList<Space> spaces = new ArrayList();
    
    public int floorCapacity;
    public int availableFloorCapacity;

    public Floor() {
    }
    
    public void createSpace(){
        
    }
    
    public int getFloorCapacity() {
        return floorCapacity;
    }

    public void setFloorCapacity(int floorCapacity) {
        this.floorCapacity = floorCapacity;
    }

    public int getAvailableFloorCapacity() {
        return availableFloorCapacity;
    }

    public void setAvailableFloorCapacity(int availableFloorCapacity) {
        this.availableFloorCapacity = availableFloorCapacity;
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }
    
    
}
