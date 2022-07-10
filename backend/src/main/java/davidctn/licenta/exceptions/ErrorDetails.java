package davidctn.licenta.exceptions;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private Date timestamp;
    private String details;

    public ErrorDetails(String message,Date timpestamp,String details){
        super();
        this.message=message;
        this.timestamp=timpestamp;
        this.details=details;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}


