package ticket.booking.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Train {
    private Integer trainId;
    private Integer trainNo;
    private Station source;
    private Station destination;
    private Map<Station,LocalTime> journey;
    private List<List<Boolean>> seats;

    public Train(Integer id, Integer no) {
        trainId = id;
        trainNo = no;
        seats = new ArrayList<>();
    }

    public Train(Integer id, Integer no, Station src, Station dest, Map<Station,LocalTime> iternary) {
        trainId = id;
        trainNo = no;
        source = src;
        destination = dest;
        journey = iternary;
        seats = new ArrayList<>();
    }

    public Integer getTrainId() { return this.trainId; }
    public Integer getTrainNo() { return this.trainNo; }
    public Station getSource() { return this.source; }
    public Station getDestination() { return this.destination; }
    public Map<Station,LocalTime> getJourneyDetails() { return this.journey; }
    public List<List<Boolean>> getSeatChart() { return this.seats; }


    public void bookSeat(int i, int j) { seats.get(i).set(j, true); }
}