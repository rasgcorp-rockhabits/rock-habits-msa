package com.rockhabits.rockhabitsmsa.domain.domaincore.exception;

public class WeekTasksNotFoundException extends RuntimeException {
    public WeekTasksNotFoundException(String message) {
        super(message);
    }

    public WeekTasksNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
