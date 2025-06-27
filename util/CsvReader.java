package util;

import model.Event;
import model.SeminarEvent;
import model.SportsEvents;
import model.CulturalEvents;
import model.WorkshopsEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private final String filePath;
    private String line, name, date, venue, type;
    private int id, capacity;
    private double fee;
    private Event newEvent;

    public CsvReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Event> loadEvents() {
        List<Event> events = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists() == false) {
            return events;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    date = parts[2];
                    venue = parts[3];
                    type = parts[4];
                    capacity = Integer.parseInt(parts[5]);
                    fee = Double.parseDouble(parts[6]);

                    // events.add(new Event(id, name, date, venue, type, capacity, fee));
                    switch(type) {
                        case "Seminars":
                            newEvent = new SeminarEvent(name, date, venue, type, capacity, fee);
                            break;
                        case "Sports Events":
                            newEvent = new SportsEvents(name, date, venue, type, capacity, fee);
                            break;
                        case "Workshops":
                            newEvent = new WorkshopsEvent(name, date, venue, type, capacity, fee);
                            break;
                        case "Cultural Events":
                            newEvent = new CulturalEvents(name, date, venue, type, capacity, fee);
                            break;
                        default:
                            System.err.println("Invalid event type in CSV: " + type);
                            continue;
                    }
                    newEvent.setId(id);
                    events.add(newEvent);
                }
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return events;
    }
}