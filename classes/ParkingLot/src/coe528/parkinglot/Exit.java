package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Exit {
    public Exit() {
    }
    
    public double calculateCost(Ticket customer, int time){
        return customer.calculateCost(time);
    }
    
    public void payForTicket(Ticket customer, String method){
        customer.payForTicket(method);
    }
}
