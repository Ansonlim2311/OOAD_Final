package User;

public abstract class User {
    private String userId;
    private String name;
    private String email;
    private String userType;
    public User(String name, String userId, String email, String userType) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.userType = userType;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    public String getUserType() {
        return userType;
    }
    public String getUserId() {
        return userId;
    }
    public String getEmail() {
        return email;
    }
}