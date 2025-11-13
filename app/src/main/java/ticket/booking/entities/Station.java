package ticket.booking.entities;

public class Station {
    private Integer stationId;
    private String stationName;

    public Station(Integer id, String name) {
        stationId = id;
        stationName = name;
    }

    public Integer getStationId() { return this.stationId; }
    public String getStationName() { return this.stationName; }
}
