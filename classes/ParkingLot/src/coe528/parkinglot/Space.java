package coe528.parkinglot;

/**
 *
 * @author uzair
 */
public class Space {
    public String type;
    public String status;
    public Ticket user;
    
    public Space(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
