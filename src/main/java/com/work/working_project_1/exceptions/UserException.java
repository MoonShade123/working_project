package com.work.working_project_1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserException extends RuntimeException {
    public UserException(final String userNotFound) {
        super(userNotFound);
    }
}
