package ticket.booking.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket {
    private String ticketId;
    private String userId;
    private Station source;
    private Station destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Train train;

    public Ticket(String tId, String uId, Station src, Station dest, LocalDateTime start, LocalDateTime end, Train tr) {
        ticketId = tId;
        userId = uId;
        source = src;
        destination = dest;
        startTime = start;
        endTime = end;
        train = tr;
    }

    public String getTicketId() { return this.ticketId; }
    public String getUserId() { return this.userId; }
    public Station getSource() { return this.source; }
    public Station getDestination() { return this.destination; }
    public LocalDateTime getStartTime() { return this.startTime; }
    public LocalDateTime getEndTime() { return this.endTime; }
    public Train getTrain() { return this.train; }

    public Duration getDuration() { return Duration.between(startTime, endTime); }
}