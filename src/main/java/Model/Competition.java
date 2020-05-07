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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
