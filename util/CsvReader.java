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
    private String line;

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
                if (parts.length == 6) {
                    String name = parts[0];
                    String date = parts[1];
                    String venue = parts[2];
                    String type = parts[3];
                    int capacity = Integer.parseInt(parts[4]);
                    double fee = Double.parseDouble(parts[5]);

                    events.add(new Event(name, date, venue, type, capacity, fee));
                }
            }
            reader.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
        return events;
    }
}