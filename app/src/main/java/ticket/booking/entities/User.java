package ticket.booking.entities;

import java.util.List;

public class User {
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private List<Ticket> ticketsBooked;

    public User(Integer id, String name, String email, String password) {
        userId = id;
        userName = name;
        userEmail = email;
        userPassword = password;
    }

    public Integer getUserId() { return this.userId; }

    public String getUserName() { return this.userName; }
    public String getUserEmail() { return this.userEmail; }
    public List<Ticket> getBookedTickets() { return this.ticketsBooked; }

    public void addTicket(Ticket t) { ticketsBooked.add(t); }
}