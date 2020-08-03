package coe528.parkinglot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
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

    public Ticket(Space space, String customerName, int timeStarted) {
        this.identifier = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        this.space = space;
        Lot.getInstance().totalNumTickets++;
        this.customerName = customerName;
        this.timeStarted = timeStarted;
        this.space.setFull(true, this);
        
        System.out.println("Made a ticket for "+customerName+ " in " + String.valueOf(space.floor.id) + "-" + String.valueOf(space.id));
        createTicketFile();
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
        this.space.setFull(false, this);
        this.deleteTicketFile();
    }
    
    public boolean canLeave(){
        return this.paid;
    }
    
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
            myWriter.write("TICKET #"+this.identifier+":\n"
                    + "Customer Name " + this.customerName + "\n"
                    + "Floor " + this.space.floor.id + "\n"
                    + "Space " + this.space.id + "\n"
                    + "Space Type: " + this.space.type + "\n"
                    + "Time Started: " + this.timeStarted + "o'clock\n"
                    + "Paid: "+ this.paid
            );
            
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
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
