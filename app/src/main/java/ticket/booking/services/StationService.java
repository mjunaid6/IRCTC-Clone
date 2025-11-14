package ticket.booking.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ticket.booking.entities.Station;

public class StationService {
    private List<Station> stations;
    private final String STATION_PATH = "src\\main\\java\\ticket\\booking\\localDB\\stations.json";
    private static ObjectMapper mapper = new ObjectMapper();

    public StationService() throws IOException{
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        stations = mapper.readValue(new File(STATION_PATH), new TypeReference<List<Station>>() {});
    }

    public Station searchStation(String st) {
        return stations.stream().filter(s -> s.getStationName().equals(st)).findFirst().get();
    }

    public boolean addStation(String name) {
        if(name == null) return false;
        stations.add(new Station(name));
        saveStations();
        return true;
    }

    public void saveStations() {
        try{
            mapper.writeValue(new File(STATION_PATH), stations);
        } catch (IOException e){
            throw new RuntimeException("Unable to save stations..", e);
        }
    }
}
