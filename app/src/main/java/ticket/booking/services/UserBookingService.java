package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Optional;

import ticket.booking.entities.Station;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

public class UserBookingService {
    private User user;
    private static final String USER_PATH = "src\\main\\java\\ticket\\booking\\localDB\\users.json";
    private static List<User> usersList;
    private static ObjectMapper mapper = new ObjectMapper();

    private StationService stationService;


    public UserBookingService() throws IOException{
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        usersList = mapper.readValue(new File(USER_PATH), new TypeReference<List<User>>() {});
        stationService = new StationService();
    }

    public boolean login(String email, String plainPassword) {
        Optional<User> foundUser = usersList.stream()
                .filter(u -> u.getUserEmail().equalsIgnoreCase(email))
                .findFirst();

        if (foundUser.isEmpty()) return false;

        if(UserServiceUtil.checkPassword(plainPassword,foundUser.get().getUserPassword())) {
            user = foundUser.get();
            return true;
        }


        return false;
    }

    public boolean signup(String name, String email, String plainPassword) {
        Optional<User> foundUser = usersList.stream()
                .filter(u -> u.getUserEmail().equalsIgnoreCase(email))
                .findFirst();
        if(foundUser.isPresent()) return false;
        String hashedPassword = UserServiceUtil.hashPassword(plainPassword);
        User user1 = new User(name, email, hashedPassword);
        usersList.add(user1);
        saveUsers();
        user = user1;
        return true;
    }

    public void fetchBooking() {
        if(user == null){ 
            System.out.println("User not found!");
            return;
        }

        List<Ticket> bookings = user.getTicketsBooked();
        if(bookings == null || bookings.isEmpty()) {
            System.out.println("No Bookings found!");
            return;
        }

        for(Ticket t : bookings) {
            t.printTicket(user.getUserName());
        }
    }

    public boolean bookTicket(String src, String dest, LocalDate date, Train train) {
        if(user == null || date == null || train == null) {
            System.out.println("Please login..");
            return false;
        }
        Station source = stationService.searchStation(src);
        Station destination = stationService.searchStation(dest);

        Map<String, LocalTime> journey = train.getJourney();
        if(journey == null || journey.isEmpty()) return false;
        LocalTime start = null, end = null;
        for(String st : journey.keySet()) {
            if(st.equals(src)) start = journey.get(st);
            if(st.equals(dest)) end = journey.get(st);
        }

        Ticket t = new Ticket(user.getUserId(),source,destination,LocalDateTime.of(date, start), LocalDateTime.of(date, end),train);

        user.addTicket(t);
        saveUsers();
        return true;
    }

    public boolean cancelBooking(String ticketId) {
        if(user == null) return false;
        List<Ticket> bookings = user.getTicketsBooked();
        for(int i = 0 ; i < bookings.size() ; i++) {
            if(bookings.get(i).getTicketId().equals(ticketId)) {
                bookings.remove(i);
                user.setTicketsBooked(bookings);
                saveUsers();
                return true;
            }
        }
        return false;
    }

    private void saveUsers() {
        try {
            mapper.writeValue(new File(USER_PATH), usersList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save users.json", e);
        }
    }
    
}
