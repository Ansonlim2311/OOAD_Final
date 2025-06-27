package model;

public class SportsEvents extends Event {
    public SportsEvents(String name, String date, String venue, String eventType, int capacity, double registrationFee) {
        
        super(name, date, venue, eventType, capacity, registrationFee);
    }

    @Override 
    public String getTypeDisplayName() { 
        return "Sports Events"; 
    }
}