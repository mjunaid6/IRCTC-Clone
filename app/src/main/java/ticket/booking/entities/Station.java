package ticket.booking.entities;

import java.util.UUID;

public class Station {
    private String stationId;
    private String stationName;

    public Station() {}

    public Station(String name) {
        this.stationId = UUID.randomUUID().toString();
        this.stationName = name;
    }

    public String getStationId() { return stationId; }
    public String getStationName() { return stationName; }

    public void setStationId(String stationId) { this.stationId = stationId; }
    public void setStationName(String stationName) { this.stationName = stationName; }
}
