package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Exit {

    /**
     *
     */
    public Exit() {
    }
    
    /**
     *
     * @param customer
     * @param time
     * @return
     */
    public double calculateCost(Ticket customer, int time){
        return customer.calculateCost(time);
    }
    
    /**
     *
     * @param customer
     * @param method
     */
    public void payForTicket(Ticket customer, String method){
        customer.payForTicket(method); 
    }
}
