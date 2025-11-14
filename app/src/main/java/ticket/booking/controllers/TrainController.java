package ticket.booking.controllers;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import ticket.booking.services.TrainService;

public class TrainController {
    private TrainService trainService;
    private Scanner sc;

    public TrainController(Scanner sc) throws IOException{
        this.sc = sc;
        trainService = new TrainService(sc);
    }

    public void addTrain() {
        System.out.print("Enter train number : ");
        String tNo = sc.nextLine();

        System.out.print("Enter Source : " );
        String src = sc.nextLine();

        System.out.print("Enter Destination : " );
        String dest = sc.nextLine();

        Map<String, LocalTime> map = new ConcurrentHashMap<>();
        while(true) {
            System.out.println("Write 'exit' to stop.");
            System.out.print("Enter station name : ");
            String stn = sc.nextLine();
            if(stn.equals("exit")) break;
            System.out.print("Enter Local time (HH:MM): ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime time = LocalTime.parse(sc.nextLine(), formatter);

            map.put(stn, time);
        }
        if(trainService.addTrain(tNo, src, dest, map)) System.out.println("Train added successfully");
        else System.out.println("Error in adding train.");
    }
}
