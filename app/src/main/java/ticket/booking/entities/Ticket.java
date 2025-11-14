package ticket.booking.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private String ticketId;
    private String userId;
    private Station source;
    private Station destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Train train;

    public Ticket() {} 

    public Ticket(String userId, Station source, Station destination, LocalDateTime starTime, LocalDateTime endTime, Train train) {
        this.ticketId = UUID.randomUUID().toString();
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.startTime = starTime;
        this.endTime = endTime;
        this.train = train;
    }

    public String getTicketId() { return ticketId; }
    public String getUserId() { return userId; }
    public Station getSource() { return source; }
    public Station getDestination() { return destination; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public Train getTrain() { return train; }

    public void setTicketId(String ticketId) { this.ticketId = ticketId; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setSource(Station source) { this.source = source; }
    public void setDestination(Station destination) { this.destination = destination; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public void setTrain(Train train) { this.train = train; }

    public Duration getDuration() {
        return Duration.between(startTime, endTime);
    }

    public void printTicket(String name) {
        System.out.println("Ticket Id : " + ticketId);
        System.out.println("This ticket is booked for : " + name);
        System.out.println("for the train number : " + train.getTrainNo());
        System.out.println("from " + source.getStationName() + " to " + destination.getStationName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Duration : " + startTime.format(formatter) + " to " + endTime.format(formatter));
        System.out.println();
    }
}
