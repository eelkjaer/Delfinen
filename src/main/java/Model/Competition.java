/**
 @author Jacob Lange Nielsen (cph-jn352@cphbusiness.dk)
 **/
package Model;

import java.time.LocalDate;

public class Competition {
    private final int id;
    private String name;
    private final String location;
    private final LocalDate timestamp;

    public Competition(int id, String name, String location, LocalDate timestamp) {
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

    public LocalDate getTimestamp() {
        return timestamp;
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
