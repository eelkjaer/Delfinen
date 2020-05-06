package Model;

import java.time.LocalDateTime;

public class Competition {
    private int id;
    private String name;
    private String location;
    private LocalDateTime timestamp;

    public Competition(int id, String name, String location, LocalDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
