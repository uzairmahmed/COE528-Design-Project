package coe528.parkinglot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * OVERVIEW: Manages the Customers parking ticket, and makes sure that text files are stored to the computer.
 * This class is mutable.
 * @author uzair
 */
public class Ticket {
    public long identifier;
    public Space space;
    public String customerName;
    public int timeStarted;
    public double cost = 0;
    public double extraCosts = 0;
    public boolean paid;

    /**
     * REQUIRES: space is a valid Space Object, timeStarted is a positive integer.EFFECTS: creates a new Ticket object that is then added to an empty parking space.MODIFIES: this.space
     * @param space
     * @param string
     * @param i
     */
    public Ticket(Space space, String customerName, int timeStarted) {
        this.identifier = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.space = space;
        Lot.getInstance().totalNumTickets++;
        this.customerName = customerName;
        this.timeStarted = timeStarted;
        this.space.setFull(true, this);
        
        System.out.println("Made a ticket for " + customerName + " in " + String.valueOf(space.floor.id) + "-"
                + String.valueOf(space.id));
        
        createTicketFile(); // Use of Abstraction
    }
    
    /**
     * REQUIRES: timeEnded is a positive integer greater than this.timeStarted
     * EFFECTS: If parked for less than 1 hour: charge $4, 2 hours: $7.50, 3 hours: $11.00, anything more will be charged $11 + $2.50/hr
     * MODIFIES: this.cost
     * @param timeEnded
     * @return
     */
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
    
    /**
     * REQUIRES: method is a String: one of [cash, card].
     * EFFECTS: set paid to true, empty the parking spot, delete the parking ticket file.
     * MODIFIES: this.paid, this.space, and `tickets/id.txt`
     * @param method
     */
    public void payForTicket(String method){
        this.paid=true;
        this.space.setFull(false, this);
        this.deleteTicketFile(); //Use of Abstraction
    }
    
    /**
     * REQUIRES: None
     * EFFECTS: returns the value of this.paid
     * MODIFIES: None
     * @return
     */
    public boolean canLeave() {
        return this.paid;
    }
    

    /**
     * Abstraction Function
     * 
     * REQUIRES: None
     * EFFECTS: Returns A string containing the important data about the Ticket
     * MODIFIES: None
     */
    public String toString() {
        return (
            "TICKET #"+this.identifier+":\n"
                    + "Customer Name " + this.customerName + "\n"
                    + "Floor " + this.space.floor.id + "\n"
                    + "Space " + this.space.id + "\n"
                    + "Space Type: " + this.space.type + "\n"
                    + "Time Started: " + this.timeStarted + "o'clock\n"
                    + "Paid: "+ this.paid
            );
    }
    
    /**
     * Abstraction Function
     * 
     * REQUIRES: None
     * EFFECTS: Creates a .txt file under `tickets/` to list the properties of the ticket
     * MODIFIES: 'tickets/id.txt'
     */
    public void createTicketFile(){
        String filename = "tickets/" + String.valueOf(this.identifier) + ".txt";
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(this.toString()); // Use of Abstraction Implemented from ToString
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /**
     * Abstraction Function
     * 
     * REQUIRES: None
     * EFFECTS: Deletes a .txt file under `tickets/`
     * MODIFIES: 'tickets/id.txt'
     */

    public void deleteTicketFile(){
        String filename = "tickets/" + String.valueOf(this.identifier) + ".txt";
        File myObj = new File(filename); 
        if (myObj.delete()) { 
          System.out.println("Deleted the file: " + myObj.getName());
        } else {
          System.out.println("Failed to delete the file.");
        } 
 
    }
}
