import java.util.ArrayList;
import java.util.List;
import java.util.Iterator; // Good practice for manual iteration/removal, but removeIf is cleaner for simple cases.

public class EventManager {
    private List<Event> events;
    private int nextEventId = 1; // For assigning unique IDs to new events

    public EventManager() {
        events = new ArrayList<>();
        // Optional: Add some dummy data with IDs for testing
        addEvent(new Event("Java Workshop", "2025-07-10", "CNMX 1001", "Workshops", 50, 150.00));
        addEvent(new Event("AI Conference", "2025-08-01", "Stadium", "Cultural Events", 200, 500.00));
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        // Assign a unique ID if the event doesn't have one (e.g., if it's a new event from the form)
        if (event.getId() == 0) { // Assuming 0 means ID not yet assigned
            event.setId(nextEventId++);
        }
        events.add(event);
    }

    // ⭐ Recommended: This method takes an eventId (int) and removes the matching event.
    public void deleteEvent(int eventId) {
        // Using removeIf is concise and efficient for Java 8+
        boolean removed = events.removeIf(event -> event.getId() == eventId);
        if (removed) {
            System.out.println("Event with ID " + eventId + " deleted successfully.");
        } else {
            System.out.println("Event with ID " + eventId + " not found for deletion.");
        }
    }

    public void updateEvent(Event updatedEvent) {
        // Find the event by ID and update it
        for (int i = 0; i < events.size(); i++) {
            Event existingEvent = events.get(i);
            if (existingEvent.getId() == updatedEvent.getId()) {
                events.set(i, updatedEvent);
                System.out.println("Event with ID " + updatedEvent.getId() + " updated successfully.");
                return;
            }
        }
        System.out.println("Event with ID " + updatedEvent.getId() + " not found for update.");
    }

}