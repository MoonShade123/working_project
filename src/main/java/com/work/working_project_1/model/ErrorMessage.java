package com.work.working_project_1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage
{
    private int errorCode;
    private String errorMsg;
    private String documentation;

    public ErrorMessage(int errorCode,String errorMsg,String documentation)
    {
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
        this.documentation=documentation;
    }
}
