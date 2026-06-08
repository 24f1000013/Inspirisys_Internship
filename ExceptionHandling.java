class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Age must be 18 or above");
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        AgeValidator val = new AgeValidator();
        try {
            val.validateAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}