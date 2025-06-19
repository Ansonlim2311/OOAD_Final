public class Event {
    private String eventName;
    private String date;
    private String venue;
    private String typeEvent;
    private int capacity;
    private double baseFee;

    public Event(String eventName, String date, String venue, String typeEvent, int capacity, double baseFee) {
        this.eventName = eventName;
        this.date = date;
        this.venue = venue;
        this.typeEvent = typeEvent;
        this.capacity = capacity;
        this.baseFee = baseFee;
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

    public String getTypeEvent() {
        return typeEvent;
    }
    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
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