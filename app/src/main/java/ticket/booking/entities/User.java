package ticket.booking.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<Ticket> ticketsBooked;

    public User() {}

    public User(String name, String email, String password) {
        this.userId = UUID.randomUUID().toString();
        this.userName = name;
        this.userEmail = email;
        this.userPassword = password;
        ticketsBooked = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public String getUserPassword() { return userPassword; }
    public List<Ticket> getTicketsBooked() { return ticketsBooked; }
    
    public void setUserId(String userId) { this.userId = userId; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }
    public void setTicketsBooked(List<Ticket> ticketsBooked) {
        this.ticketsBooked = ticketsBooked;
    }

    public void addTicket(Ticket t) { ticketsBooked.add(t); }
}
