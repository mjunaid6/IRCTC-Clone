package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

import ticket.booking.entities.Station;
import ticket.booking.entities.Train;

public class TrainService {
    private List<Train> trains;
    private final String TRAIN_PATH = "src\\\\main\\\\java\\\\ticket\\\\booking\\\\localDB\\\\trains.json";
    private static ObjectMapper mapper = new ObjectMapper();
    private StationService stationService;
    private Scanner sc;

    public TrainService(Scanner sc) throws IOException{
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        trains = mapper.readValue(new File(TRAIN_PATH), new TypeReference<List<Train>>() {});
        stationService = new StationService();
        this.sc = sc;
    }

    public List<Train> searchTrains(String src, String dest) {
        return trains.stream().filter(t -> {
            LocalTime i = t.getJourney().get(src);
            LocalTime j = t.getJourney().get(dest);
            return (i != null) && (j != null) && (i.isBefore(j));
        }).toList();
    }

    public Train selectTrain(String src, String dest) {
        List<Train> filteredTrains =  searchTrains(src, dest);
        System.out.println("These are the trains from " + src + " to " + dest + " : ");
        for(Train t : filteredTrains) t.trainDetails();

        System.out.println("Enter train no of train to book : ");
        String tNo = sc.nextLine();

        for(Train t : filteredTrains) if(t.getTrainNo().equalsIgnoreCase(tNo)) return t;

        return null;
    }

    public boolean addTrain(String trainNo, String src, String dest, Map<String,LocalTime> journey) {
        if(journey == null || journey.isEmpty()) return false;

        Station source = stationService.searchStation(src);
        Station destination = stationService.searchStation(dest);

        trains.add(new Train(trainNo, source, destination, journey));
        saveTrains();
        return true;
    }

    public void saveTrains() {
        try{
            mapper.writeValue(new File(TRAIN_PATH), trains);
        } catch (IOException e) {
            throw new RuntimeException("Not able to save trains",e);
        }
    }
}
