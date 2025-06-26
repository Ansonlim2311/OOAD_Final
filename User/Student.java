package User;

public class Student extends User {
    public static final double DISCOUNT = 10;

    public Student(String name, String userId, String email, String userType){
        super(name, userId, email, "Student");
    }

    public double getDiscount(){ 
        return DISCOUNT; 
    }
}