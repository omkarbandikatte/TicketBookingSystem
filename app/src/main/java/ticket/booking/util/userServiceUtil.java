package ticket.booking.util;
import org.mindrot.jbcrypt.BCrypt;
import ticket.booking.entities.User;
public class userServiceUtil {
    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt()); // Gensalt do hashing that means it convert every char of the password into cipher text
    }

    public static Boolean checkPassword(String plainPassword, String hashedPassword){
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
