package ticket.booking.services;
import ticket.booking.entities.User;
import java.io.File;
import java.io.IOException;
import java.util.*;
import ticket.booking.util.userServiceUtil;
import ticket.booking.entities.Train;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;


public class UserBookingService {

    private User user;

    private List<User> userlist;

    private static final String USERS_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

    private ObjectMapper object_mapper = new ObjectMapper();

    public UserBookingService(User user1) throws StreamReadException, DatabindException, IOException {
        this.user = user1;
        // File userFile = new File(USERS_PATH);  // Path to the JSON File
        // if(userFile.exists() && userFile.length() != 0){
        //     userlist = object_mapper.readValue(userFile, new TypeReference<List<User>>() {});
        // }
        // else{
        //     userlist = new ArrayList<>();
        // }
        loadUser();
    }

    public UserBookingService() throws IOException{
        loadUser();
    }

    public List<User> loadUser() throws IOException{
        File userFile = new File(USERS_PATH);
        return object_mapper.readValue(userFile, new TypeReference<List<User>>() {});
    }
    public Boolean loginUser(){
        Optional<User> foundUser = userlist.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && userServiceUtil.checkPassword(user.getPassword(), user1.getHashpassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userlist.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }
        catch(IOException ex){
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException{
        File userFile = new File(USERS_PATH);
        object_mapper.writeValue(userFile, userlist);
    }

    // --json -> Object(User) -> Deserialize
    // Object(User) -> json -> Serialize

    public void fetchBooking(){
        user.printTicket();
    }

    public Boolean cancelBooking(String TicketId) {
        boolean removed = user.getTicketsbooked().removeIf(ticket -> ticket.getTicketId().equalsIgnoreCase(TicketId));
        if (removed) {
            try {
                saveUserListToFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return removed;
    }

    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            trainService.searchTrains(source, destination);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
