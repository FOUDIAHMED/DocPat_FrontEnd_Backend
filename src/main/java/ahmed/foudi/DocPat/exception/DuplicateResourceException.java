package ahmed.foudi.DocPat.exception;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(String message) {
        super(message);
    }

    public static DuplicateResourceException emailAlreadyExists(String email) {
        return new DuplicateResourceException("Email already exists: " + email);
    }

    public static DuplicateResourceException licenseNumberExists(String licenseNumber) {
        return new DuplicateResourceException("License number already exists: " + licenseNumber);
    }
}
