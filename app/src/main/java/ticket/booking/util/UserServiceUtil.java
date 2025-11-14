package ticket.booking.util;

import org.mindrot.jbcrypt.BCrypt;


public class UserServiceUtil {
    public static String hashPassword(String plainPassWord) {
        return BCrypt.hashpw(plainPassWord,BCrypt.gensalt(10));
    }

    public static boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
