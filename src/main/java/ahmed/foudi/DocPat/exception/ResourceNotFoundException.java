package ahmed.foudi.DocPat.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException doctorNotFound(Long id) {
        return new ResourceNotFoundException("Doctor not found with id: " + id);
    }

    public static ResourceNotFoundException patientNotFound(Long id) {
        return new ResourceNotFoundException("Patient not found with id: " + id);
    }

    public static ResourceNotFoundException appointmentNotFound(Long id) {
        return new ResourceNotFoundException("Appointment not found with id: " + id);
    }
}
