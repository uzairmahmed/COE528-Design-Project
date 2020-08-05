package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class EVSpace extends Space{

    /**
     *
     * @param type
     * @param floor
     */
    public EVSpace(String type, Floor floor) {
        super(type, floor);
    }
    
    /**
     *
     */
    public void charge(){
        this.user.extraCosts+=10.00;
    }
}
