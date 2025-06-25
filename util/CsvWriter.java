package util;

import model.Event;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private final String filePath;

    public CsvWriter(String filePath) {
        this.filePath = filePath;
    }

    public void appendEvent(Event event) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.append(event.getEventName()).append(',');
            writer.append(event.getDate()).append(',');
            writer.append(event.getVenue()).append(',');
            writer.append(event.getEventType()).append(',');
            writer.append(String.valueOf(event.getCapacity())).append(',');
            writer.append(String.valueOf(event.getBaseFee())).append('\n');
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}