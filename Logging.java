import java.util.logging.Logger;
public class Logging {
    private static final Logger logger = Logger.getLogger(Logging.class.getName());
    public static void main(String[] args) {
        logger.info("Application started");
        String username = "Kavya";
        logger.info("User logged in: " + username);
        int age = 15;
        if (age < 18)
            logger.warning("User is underage");
        logger.severe("Sample severe log message");
        logger.info("Application terminated");
    }
}