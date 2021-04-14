package com.work.working_project_1.exceptions;

public class CustomValidationException extends RuntimeException
{
    public CustomValidationException(String msg)
    {
        super(msg);
    }
}
