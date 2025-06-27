package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.io.IOException;

import model.Event;

public class CsvWriter {
    private final String filePath;
    private BufferedWriter writer;

    public CsvWriter(String filePath) {
        this.filePath = filePath;
    }

    public void appendEvent(Event event) {
        try {
            writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(formatEvent(event));
            writer.newLine();
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void updateCsv(List<Event> events) {
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            for (Event e : events) {
                writer.write(formatEvent(e));
                writer.newLine();
            } 
            writer.close();
        } catch (IOException error) {
                error.printStackTrace();
        }
    }

    private String formatEvent(Event event) {
        return String.join(",",
                String.valueOf(event.getId()),
                event.getEventName(),
                event.getDate(),
                event.getVenue(),
                event.getEventType(),
                String.valueOf(event.getCapacity()),
                String.valueOf(event.getBaseFee()));
    }
}