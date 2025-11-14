package ticket.booking.controllers;

import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDate;

import ticket.booking.entities.Train;
import ticket.booking.services.TrainService;
import ticket.booking.services.UserBookingService;

public class UserController {
    UserBookingService userBookingService;
    TrainService trainService;
    Scanner sc;
    
    public UserController(Scanner sc) throws IOException{
        userBookingService = new UserBookingService();
        this.sc = sc;
        trainService = new TrainService(this.sc);
    }

    public void login() {
        System.out.print("Enter your Email id : ");
        String email = sc.nextLine();

        System.out.print("Enter your password : ");
        String password = sc.nextLine();

        if(userBookingService.login(email, password)) System.out.println("User logged in..");
        else System.out.println("Unable to log in user..");
    }

    public void signup() {
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        System.out.print("Enter your Email id : ");
        String email = sc.nextLine();

        System.out.print("Enter your password : ");
        String password = sc.nextLine();

        if(userBookingService.signup(name, email, password)) System.out.println("User signned up...");
        else System.out.println("Unable to sign up user...");
    }
    
    public void fetchBooking() {
        userBookingService.fetchBooking();
    }

    public void bookTicket() {
        System.out.print("Enter the source station : ");
        String src = sc.nextLine();
        System.out.print("Enter the destination station : ");
        String dest = sc.nextLine();

        System.out.print("Enter date of journey : ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        Train t = trainService.selectTrain(src, dest);

        if(userBookingService.bookTicket(src, dest, date, t)) System.out.println("Ticket booked successfully..");
        else System.out.println("Unable to book ticket");
    }

    public void cancelBooking() {
        System.out.print("Enter the ticket id : ");
        String tid = sc.nextLine();

        if(userBookingService.cancelBooking(tid)) System.out.println("Ticket cancelled successfully..");
        else System.out.println("Unable to cancel ticket");
    }
}
