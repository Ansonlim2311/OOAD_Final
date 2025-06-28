package model;

import java.util.ArrayList;
import java.util.List;
import util.CsvReader;
import util.CsvWriter;

public class EventManager {
    private List<Event> events;
    private int nextEventId = 1; // For assigning unique IDs to new events
    private boolean removed;
    private Event existingEvent;
    private CsvReader fileReader;
    private CsvWriter fileWriter;

    public EventManager(CsvReader fileReader, CsvWriter fileWriter) {
        events = new ArrayList<>();
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.events = new ArrayList<>(fileReader.loadEvents());

        for (Event e : events) {
            if (e.getId() >= nextEventId) {
                nextEventId = e.getId() + 1;
            }
        }
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
        fileWriter.appendEvent(event);
    }

    // This method takes an eventId (int) and removes the matching event.
    public void deleteEvent(int eventId) {
        // Using removeIf is concise and efficient for Java 8+
        removed = events.removeIf(event -> event.getId() == eventId);
        if (removed) {
            fileWriter.updateCsv(events);
            System.out.println("Event with ID " + eventId + " deleted successfully.");
        } else {
            System.out.println("Event with ID " + eventId + " not found for deletion.");
        }
    }
    public Event getEventAt(int index) {
    if (index >= 0 && index < events.size()) {
        return events.get(index);
        } else {
        throw new IndexOutOfBoundsException("Invalid index for event list: " + index);
        }
    }

    public void updateEvent(Event updatedEvent) {
        // Find the event by ID and update it
        for (int i = 0; i < events.size(); i++) {
            existingEvent = events.get(i);
            if (existingEvent.getId() == updatedEvent.getId()) {
                events.set(i, updatedEvent);
                fileWriter.updateCsv(events);
                System.out.println("Event with ID " + updatedEvent.getId() + " updated successfully.");
                return;
            }
        }
        System.out.println("Event with ID " + updatedEvent.getId() + " not found for update.");
    }
}