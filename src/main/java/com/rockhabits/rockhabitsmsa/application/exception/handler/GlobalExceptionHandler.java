package com.rockhabits.rockhabitsmsa.application.exception.handler;

import com.rockhabits.rockhabitsmsa.domain.domaincore.exception.WeekTasksNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = {WeekTasksNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(WeekTasksNotFoundException weekTasksNotFoundException) {
        log.error(weekTasksNotFoundException.getMessage(), weekTasksNotFoundException);
        return ErrorDTO.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(weekTasksNotFoundException.getMessage())
                .build();
    }
}
