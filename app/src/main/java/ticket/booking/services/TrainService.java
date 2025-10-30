package ticket.booking.services;
import ticket.booking.entities.Train;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Ticket;




public class TrainService {
    private static final String TRAINS_PATH = "app/src/main/java/ticket/booking/localDb/trains.json";
    File trainFile = new File(TRAINS_PATH);
    private ObjectMapper object_mapper = new ObjectMapper();
    private  List<Train> trainList;

    public TrainService() throws StreamReadException, DatabindException, IOException {
        File trainFile = new File(TRAINS_PATH);  // Path to the JSON File
        trainList = object_mapper.readValue(trainFile, new TypeReference<List<Train>>() {});
    }
    public List<Train> searchTrains(String source, String destination){
        return trainList.stream()   
            .filter(train -> validTrain(train, source, destination))
            .collect(Collectors.toList());
    }

    public Boolean validTrain(Train train, String source, String destination){
        List<String> stations = train.getStations();
        int sourceIndex = stations.indexOf(source.toLowerCase());
        int destinationIndex = stations.indexOf(destination.toLowerCase());
        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }
}
