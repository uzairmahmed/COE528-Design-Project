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
        
        
    public static void main(String args[]){
        ParkingLot parkinglot = new ParkingLot();
        
        parkinglot.mainLot.createFloor(10, 20, 40, 10, 1);
    }
}
