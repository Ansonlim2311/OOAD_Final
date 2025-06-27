package model;

public class SeminarEvent extends Event {
    public SeminarEvent(String name, String date, String venue, String eventType, int capacity, double registrationFee) {

        super(name, date, venue, eventType, capacity, registrationFee);
    }

    @Override 
    public String getTypeDisplayName() { 
        return "Seminar"; 
    }
}