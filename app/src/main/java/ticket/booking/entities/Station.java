package ticket.booking.entities;

public class Station {
    private String stationId;
    private String stationName;

    public Station(String id, String name) {
        stationId = id;
        stationName = name;
    }

    public String getStationId() { return this.stationId; }
    public String getStationName() { return this.stationName; }
}
