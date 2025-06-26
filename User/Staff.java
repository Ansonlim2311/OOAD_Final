package User;

public class Staff extends User {
    public static final double DISCOUNT = 15;

    public Staff(String name, String userId, String email, String userType){
        super(name, userId, email, "Staff");
    }

    public double getDiscount(){ 
        return DISCOUNT; 
    }   
}
