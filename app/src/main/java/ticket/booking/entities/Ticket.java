package ticket.booking.entities;
import java.util.Date;

public class Ticket {
    private String TicketId;
    private String UserId;
    private String dateofTravel;
    private String source;
    private String destination;
    private Train train;

    public Ticket(String TicketId, String UserId, String dateofTravel, String source, String destination, Train train){
        this.TicketId = TicketId;
        this.UserId = UserId;
        this.dateofTravel = dateofTravel;
        this.source = source;
        this.destination = destination;
        this.train = train;
    }

    public String getTicketId(){
        return TicketId;
    }
    public String getUserId(){
        return UserId;
    }
    public String getDateofTravel(){
        return dateofTravel;
    }
    public String getSource(){
        return source;
    }
    public String getDestination(){
        return destination;
    }
    public Train getTrain(){
        return train;
    }
    public void setTicketId(String TicketId){
        this.TicketId = TicketId;
    }
    public void setUserId(String UserId){
        this.UserId = UserId;
    }
    public void setDateofTravel(String dateofTravel){
        this.dateofTravel = dateofTravel;
    }
    public void setSource(String source){
        this.source = source;
    }
    public void setDestination(String destination){
        this.destination = destination;
    }
    public void setTrain(Train train){
        this.train = train;
    }

    public String getTicketInfo(){
        return "Ticket ID: " + TicketId + ", User ID: " + UserId + ", Date of Travel: " + dateofTravel + ", Source: " + source + ", Destination: " + destination + ", Train: " + train.getTrainInfo();
    }
}
