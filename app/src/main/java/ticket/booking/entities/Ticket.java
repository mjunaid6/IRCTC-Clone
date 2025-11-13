package ticket.booking.entities;

import java.time.LocalDateTime;

public class Ticket {
    private Integer ticketId;
    private Integer userId;
    private Station source;
    private Station destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Train train;

    public Ticket(Integer tId, Integer uId, Station src, Station dest, LocalDateTime start, LocalDateTime end, Train tr) {
        ticketId = tId;
        userId = uId;
        source = src;
        destination = dest;
        startTime = start;
        endTime = end;
        train = tr;
    }

    public Integer getTicketId() { return this.ticketId; }
    public Integer getUserId() { return this.userId; }
    public Station getSource() { return this.source; }
    public Station getDestination() { return this.destination; }
    public LocalDateTime getStartTime() { return this.startTime; }
    public LocalDateTime getEndTime() { return this.endTime; }
    public Train getTrain() { return this.train; }
}