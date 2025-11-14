package ticket.booking.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<Ticket> ticketsBooked;

    public User(String id, String name, String email, String password) {
        userId = id;
        userName = name;
        userEmail = email;
        userPassword = password;
        ticketsBooked = new ArrayList<>();
    }

    public String getUserId() { return this.userId; }

    public String getUserName() { return this.userName; }
    public String getUserEmail() { return this.userEmail; }

    public String getPassword() { return this.userPassword; }
    public List<Ticket> getBookedTickets() { return this.ticketsBooked; }

    public void setBookings(List<Ticket> bookings) { this.ticketsBooked = bookings; }

    public void addTicket(Ticket t) { ticketsBooked.add(t); }
}