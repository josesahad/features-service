package org.jsahad.api.handler;

import java.util.Date;

/**
 * Represents an error integrated seamlessly with default Spring Boot errors.
 */
public class RestError {

    private final Date timestamp;

    private final int status;

    private final String error;

    private final String message;

    private final String path;

    public RestError(Date timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPath() {
        return this.path;
    }
}
