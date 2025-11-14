package ticket.booking.controllers;

import java.io.IOException;
import java.util.Scanner;

import ticket.booking.services.StationService;

public class StationController {
    private StationService stationService;
    private Scanner sc;

    public StationController(Scanner sc) throws IOException{
        stationService = new StationService();
        this.sc = sc;
    }

    public void addStation() {
        System.out.print("Enter the name of station to add : ");
        String stName = sc.nextLine();

        if(stationService.addStation(stName)) System.out.println("Station added successfully..");
        else System.out.println("Unable to add station...");
    }
}
