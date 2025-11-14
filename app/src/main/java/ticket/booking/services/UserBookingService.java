package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Ticker;

import java.util.Optional;

import ticket.booking.entities.Ticket;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

public class UserBookingService {
    private User user;
    private static final String USER_PATH = "../localDB/users.json";
    private static List<User> usersList;
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        try {
            usersList = mapper.readValue(new File(USER_PATH), new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Unable to load users.json", e);
        }
    }

    public boolean login(String email, String plainPassword) {
        Optional<User> foundUser = usersList.stream()
                .filter(u -> u.getUserEmail().equalsIgnoreCase(email))
                .findFirst();

        if (foundUser.isEmpty()) return false;

        if(UserServiceUtil.checkPassword(plainPassword,foundUser.get().getPassword())) {
            user = foundUser.get();
            return true;
        }

        return false;
    }

    public boolean signup(String id, String name, String email, String plainPassword) {
        Optional<User> foundUser = usersList.stream()
                .filter(u -> u.getUserEmail().equalsIgnoreCase(email))
                .findFirst();
        if(foundUser.isPresent()) return false;
        String hashedPassword = UserServiceUtil.hashPassword(plainPassword);
        User user1 = new User(id, name, email, hashedPassword);
        usersList.add(user1);
        saveUsers();
        user = user1;
        return true;
    }

    private void saveUsers() {
        try {
            mapper.writeValue(new File(USER_PATH), usersList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save users.json", e);
        }
    }

    public void fetchBooking() {
        List<Ticket> bookings = user.getBookedTickets();
        for(Ticket t : bookings) {
            t.printTicket();
        }
    }

    public boolean cancelBooking(String ticketId) {
        List<Ticket> bookings = user.getBookedTickets();
        for(Ticket t : bookings) {
            if(t.getTicketId().equals(ticketId)) {
                bookings.remove(t);
                user.setBookings(bookings);
                return true;
            }
        }
        return false;
    }
    
}
