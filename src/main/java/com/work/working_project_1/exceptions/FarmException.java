package com.work.working_project_1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Farm not found")
public class FarmException extends RuntimeException {
    public FarmException(final String farmNotFound) {
        super(farmNotFound);
    }
}
