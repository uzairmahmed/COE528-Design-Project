package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Entrance {

    public Entrance() {
    }
    
    public void chooseAnEmptySpot(String type){
        for (Floor f : Lot.getInstance().floors){
            if (f.getAvailableFloorCapacity()[f.map.get(type)] > 0){
                System.out.println("got " + f.getSpaces(type).size() + " free spaces in floor " + f.id + " of type " + type);
            }
        }
    }
    
    public void createNewTicket(){
        
    }
}
