package ticket.booking.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private Station source;
    private Station destination;
    private Map<String,LocalTime> journey;
    private List<List<Boolean>> seats;

    public Train(String id, String no) {
        trainId = id;
        trainNo = no;
        seats = new ArrayList<>();
    }

    // public Train(String id, String no, Station src, Station dest, Map<String,LocalTime> iternary) {
    //     trainId = id;
    //     trainNo = no;
    //     source = src;
    //     destination = dest;
    //     journey = iternary;
    //     seats = new ArrayList<>();
    //     for(int i = 0)
    // }

    public Train(String id, String no, Station src, Station dest, Map<String,LocalTime> iternary, List<List<Boolean>> seatInfo) {
        trainId = id;
        trainNo = no;
        source = src;
        destination = dest;
        journey = iternary;
        seats = seatInfo;
    }

    public String getTrainId() { return this.trainId; }
    public String getTrainNo() { return this.trainNo; }
    public Station getSource() { return this.source; }
    public Station getDestination() { return this.destination; }
    public Map<String,LocalTime> getJourneyDetails() { return this.journey; }
    public List<List<Boolean>> getSeatChart() { return this.seats; }


    public boolean bookSeat(int i, int j) { 
        if(i < 0 || i >= seats.size()) return false;
        if(j < 0 || j >= seats.get(0).size()) return false;
        seats.get(i).set(j, true); 
        return true;
    }
}