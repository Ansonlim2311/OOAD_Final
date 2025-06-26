package util;

import model.Event;

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

                    events.add(new Event(id, name, date, venue, type, capacity, fee));
                }
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return events;
    }
}