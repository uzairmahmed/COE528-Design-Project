package coe528.parkinglot;

/**
 * @author uzair
 */
public class Entrance {
    public Entrance() {
    }
    
    /**
     * @param type
     * @return
     */
    public Space chooseAnEmptySpace(String type){
        for (Floor f : Lot.getInstance().floors){
            if (f.getAvailableFloorCapacity()[f.map.get(type)] > 0){
                System.out.println("got " + f.getSpaces(type).size() + " free spaces in floor " + f.id + " of type " + type);
                return f.getSpaces(type).get(0);
            }
        }
        return null;
    }
    
    /**
     * @param space
     * @param customer
     * @param time
     * @return
     */
    public Ticket createNewTicket(Space space, String customer, int time){
        if (space != null){
            Ticket ticket = new Ticket(space, customer, time);
            return ticket;
        }
        else return null;
    }
}
