package ticket.booking.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Train {
    private String trainId;
    private String trainNo;
    private Station source;
    private Station destination;
    private Map<String, LocalTime> journey;
    private List<List<Boolean>> seats;

    public Train() {} 

    public Train(String tNO, Station source, Station destination, Map<String,LocalTime> journey) {
        this.trainId = UUID.randomUUID().toString();
        this.trainNo = tNO;
        this.source = source;
        this.destination = destination;
        this.journey = journey;
        this.seats = new ArrayList<>();        
    }

    public String getTrainId() { return trainId; }
    public String getTrainNo() { return trainNo; }
    public Station getSource() { return source; }
    public Station getDestination() { return destination; }
    public Map<String, LocalTime> getJourney() { return journey; }
    public List<List<Boolean>> getSeats() { return seats; }

    public void setTrainId(String trainId) { this.trainId = trainId; }
    public void setTrainNo(String trainNo) { this.trainNo = trainNo; }
    public void setSource(Station source) { this.source = source; }
    public void setDestination(Station destination) { this.destination = destination; }
    public void setJourney(Map<String, LocalTime> journey) { this.journey = journey; }
    public void setSeats(List<List<Boolean>> seats) { this.seats = seats; }

    public void trainDetails() {
        System.out.println("Train No : " + trainNo);
        System.out.println("Train Source : " + source.getStationName());
        System.out.println("Train Destination : " + destination.getStationName());
    }

    public boolean bookSeat(int i, int j) {
        if (i < 0 || i >= seats.size()) return false;
        if (j < 0 || j >= seats.get(i).size()) return false;
        seats.get(i).set(j, true);
        return true;
    }
}
