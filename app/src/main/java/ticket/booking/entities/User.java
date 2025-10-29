package ticket.booking.entities;
import ticket.booking.entities.Ticket;
import java.util.*;

public class User {
    private String name;
    private String password;
    private String hashpassword;
    private List<Ticket> ticketsbooked;
    private String UserId;
    public User(String name, String password, String hashpassword, List<Ticket> ticketsbooked, String UserId) {
        this.name = name;
        this.password = password;
        this.hashpassword = hashpassword;
        this.UserId = UserId;
        this.ticketsbooked = ticketsbooked;
    }

    public User(){}

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getHashpassword(){
        return hashpassword;
    }
    public String getUserId(){
        return UserId;
    }
    public List<Ticket> getTicketsbooked(){
        return ticketsbooked;
    }

    public void printTicket(){
        for(int i=0;i<ticketsbooked.size();i++){
            System.out.println(ticketsbooked.get(i).getTicketInfo());
        }
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setHashpassword(String hashpassword){
        this.hashpassword = hashpassword;
    }
    public void setUserId(String UserId){
        this.UserId = UserId;
    }
    public void setTicketsbooked(List<Ticket> ticketsbooked){
        this.ticketsbooked = ticketsbooked;
    }
}
