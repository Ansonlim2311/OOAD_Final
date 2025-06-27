package model;

public class WorkshopsEvent extends Event {
    public WorkshopsEvent(String name, String date, String venue, String eventType, int capacity, double registrationFee) {

        super(name, date, venue, eventType, capacity, registrationFee);
    }

    @Override 
    public String getTypeDisplayName() { 
        return "Workshops"; 
    }
}