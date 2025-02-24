package ahmed.foudi.DocPat.exception;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }

    public static UnauthorizedAccessException notOwner() {
        return new UnauthorizedAccessException("You are not authorized to access this resource");
    }

    public static UnauthorizedAccessException invalidCredentials() {
        return new UnauthorizedAccessException("Invalid email or password");
    }
}
