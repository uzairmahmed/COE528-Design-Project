package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Ticket {
    public int spaceID;
    public int floorID;
    public String customerName;
    public int timeStarted;
    public double cost = 0;
    public double extraCosts = 0;
    public boolean paid;

    public Ticket(int floorID, int spaceID, String customerName, int timeStarted) {
        this.floorID = floorID;
        this.spaceID = spaceID;
        Lot.getInstance().totalNumTickets++;
        this.customerName = customerName;
        this.timeStarted = timeStarted;
    }
    
    public double calculateCost(int timeEnded){
        int timeElapsed = timeEnded - this.timeStarted;
        
        if (timeElapsed <= 1){
            this.cost = 4.00;
        } else if (timeElapsed == 2){
            this.cost = 7.50;
        } else if (timeElapsed == 3){
            this.cost = 11.00;
        } else {
            double temp = (timeElapsed - 3)*2.5;
            this.cost = temp + 11.00;
        }
        
        return this.cost + this.extraCosts;
    }
    
    public void payForTicket(String method){
        this.paid=true;        
    }
}
