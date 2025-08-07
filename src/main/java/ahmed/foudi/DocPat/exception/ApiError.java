package ahmed.foudi.DocPat.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ApiError {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(int status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
