package ahmed.foudi.DocPat.exception;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }

    public static InvalidOperationException appointmentCancellationTimeExpired() {
        return new InvalidOperationException("Cannot cancel appointment less than 24 hours before");
    }

    public static InvalidOperationException invalidAppointmentStatus(String currentStatus, String requiredStatus) {
        return new InvalidOperationException("Invalid appointment status: " + currentStatus + ". Required: " + requiredStatus);
    }

    public static InvalidOperationException paymentAlreadyProcessed() {
        return new InvalidOperationException("Payment has already been processed");
    }
}
