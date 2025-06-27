package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.EventFactory;
import model.Event;

public class CsvReader {
    private final String filePath;
    private String line, name, date, venue, type;
    private int id, capacity;
    private double fee;
    private Event newEvent;
    private List<Event> events = new ArrayList<>();
    private File file;
    private String[] parts;
    private EventFactory eventFactory = new EventFactory();

    public CsvReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Event> loadEvents() {
        file = new File(filePath);
        if (file.exists() == false) {
            return events;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                parts = line.split(",");
                if (parts.length == 7) {
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    date = parts[2];
                    venue = parts[3];
                    type = parts[4];
                    capacity = Integer.parseInt(parts[5]);
                    fee = Double.parseDouble(parts[6]);

                    newEvent = eventFactory.createWithId(id, name, date, venue, type, capacity, fee);
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