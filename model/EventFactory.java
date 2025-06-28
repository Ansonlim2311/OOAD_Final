package model;

public class EventFactory {
    public Event create(String name, String date, String venue, String type, int capacity, double fee) {

        switch (type) {
            case "Seminars":
                return new SeminarEvent(name, date, venue, type, capacity, fee);
            case "Sports Events":
                return new SportsEvents(name, date, venue, type, capacity, fee);
            case "Workshops":
                return new WorkshopsEvent(name, date, venue, type, capacity, fee);
            case "Cultural Events":
                return new CulturalEvents(name, date, venue, type, capacity, fee);
            default:
                throw new IllegalArgumentException("Unknown event type: " + type);
        }
    }

    public Event createWithId(int id, String name, String date, String venue, String type, int capacity, double fee) {
        Event event = create(name, date, venue, type, capacity, fee);
        event.setId(id);
        return event;
    }
}