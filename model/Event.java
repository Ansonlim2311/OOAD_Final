package model;
public class Event {
    private int id; // Add this field for a unique identifier
    private String eventName;
    private String date;
    private String venue;
    private String eventType;
    private int capacity;
    private double baseFee;

    public Event(int id, String eventName, String date, String venue, String eventType, int capacity, double baseFee) {
        this.id = id; // Initialize the ID
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
        this.eventType = eventType;
        this.capacity = capacity;
        this.baseFee = baseFee;
    }

    public Event(String eventName, String date, String venue, String eventType, int capacity, double baseFee) {
        this(0, eventName, date, venue, eventType, capacity, baseFee); // Call the main constructor with a default ID (e.g., 0)
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventType() {
        return eventType;
    }
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getBaseFee() {
        return baseFee;
    }
    public void setBaseFee(double baseFee) {
        this.baseFee = baseFee;
    }
}