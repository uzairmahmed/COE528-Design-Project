package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Space {
    public Floor floor;
    public int id;
    public String type;
    public boolean full;
    public Ticket user;
    
    public Space(String type, Floor floor) {
        this.type = type;
        this.full = false;
        
        this.id = floor.getTotalFloorCapacity()+1;
        
        floor.spaces.add(this);
        floor.floorCapacity[floor.map.get(this.type)]++;
        floor.availableFloorCapacity[floor.map.get(this.type)]++;

    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean value, Ticket user) {
        this.full = value;
        this.user = user;
    }    
}
