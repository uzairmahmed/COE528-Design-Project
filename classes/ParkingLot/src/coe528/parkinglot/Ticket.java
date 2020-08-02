package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Ticket {
    public int id;
    public String customerName;
    public int timeStarted;
    public double cost;
    public boolean paid;

    public Ticket(int id, String customerName) {
        this.customerName = customerName;
    }
    
    public void calculateCost(int timeEnded){
        
    }
    
    public void payForTicket(){
        
    }
}
