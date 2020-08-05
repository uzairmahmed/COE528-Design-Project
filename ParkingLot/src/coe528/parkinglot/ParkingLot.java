/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class ParkingLot {
    Lot mainLot;
    public ParkingLot() {
        this.mainLot = Lot.getInstance();
    }
        
    /**
     * @param args
     */
    public static void main(String args[]){
        ParkingLot parkinglot = new ParkingLot();
        
        parkinglot.mainLot.createFloor(30, 20, 10, 10, 5);
        parkinglot.mainLot.createFloor(10, 50, 10, 0, 5);
        parkinglot.mainLot.createFloor(10, 20, 20, 10, 15);
        
        parkinglot.mainLot.getCapacity();        
        parkinglot.mainLot.getAvailableCapacity();
        
        Space tempSpace = parkinglot.mainLot.entrance1.chooseAnEmptySpace("compact");
        Ticket johnTicket = parkinglot.mainLot.entrance1.createNewTicket(tempSpace, "John", 0);
       
        parkinglot.mainLot.getAvailableCapacity();
        
        System.out.println("John's Ticket after 5 hours is $"+johnTicket.calculateCost(5));
        
        System.out.println("John can leave: " + johnTicket.canLeave());
        
        parkinglot.mainLot.exit1.payForTicket(johnTicket, "cash");
        System.out.println("John paid in cash");

        System.out.println("John can leave: " + johnTicket.canLeave());
        
        parkinglot.mainLot.getAvailableCapacity();
        
    }
}
