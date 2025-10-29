package ticket.booking;
import java.util.*;
import java.util.stream.Collectors;
import ticket.booking.entities.*;
import ticket.booking.services.*;
import ticket.booking.util.userServiceUtil;
import java.util.UUID;
import java.util.Scanner;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ticket Booking System!");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService = null;
        try{
            userBookingService = new UserBookingService();
        }
        catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }

        while(option != 7){
            System.out.println("Please select an option:");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Fetch Booking");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Exit App");

            option = scanner.nextInt();
            switch(option){
                case 1:
                    // Login
                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    User loginUser = new User(name, password, userServiceUtil.hashPassword(password), new ArrayList<>(), UUID.randomUUID().toString());
                    try{
                        userBookingService = new UserBookingService(loginUser);
                    }
                    catch(IOException e){
                        System.out.println("An error occurred: " + e.getMessage());

                    }
                    break;
                case 2:
                    // Sign Up
                    System.out.println("Enter your name:");
                    String name1 = scanner.next();
                    System.out.println("Enter your password:");
                    String password1 = scanner.next();
                    User signUpUser = new User(name1, password1, userServiceUtil.hashPassword(password1), new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService.signUp(signUpUser);
                    break;
                case 3:
                    System.out.println("Fetch Booking");
                    userBookingService.fetchBooking();
                    break;
                case 4:
                    // Search Trains
                    System.out.println("Search Trains");
                    System.out.println("Enter the Source station");
                    String source = scanner.next();
                    source = source.toLowerCase();
                    if(source.isEmpty()){
                        System.out.println("Source station cannot be empty");
                        break;
                    }
                    System.out.println("Enter the Destination Station");
                    String destination = scanner.next();
                    destination = destination.toLowerCase();
                    if(destination.isEmpty()){
                        System.out.println("Destination station cannot be empty");
                        break;
                    }
                    if(source.equals(destination)){
                        System.out.println("Source and Destination cannot be the same");
                        break;
                    }
                    List<Train> trains = userBookingService.getTrains(source, destination);
                    break;
                case 5:
                    // Cancel Ticket
                    break;
                case 6:
                    // View Train Schedule
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
