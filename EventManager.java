import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    // public void deleteEvent(int eventId) {
    //     events.removeIf(event -> event.getId() == eventId);
    // }

    // public void updateEvent(Event updatedEvent) {
    //     for (int i = 0; i < events.size(); i++) {
    //         if (events.get(i).getId() == updatedEvent.getId()) {
    //             events.set(i, updatedEvent);
    //             return;
    //         }
    //     }
    //     // If event with ID is not found, you might want to throw an exception or handle it in some other way
    // }
}
