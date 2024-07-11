package com.project.taskmanagement.core.exception;

import com.project.taskmanagement.core.exception.type.AlreadyExistsExceptionType;
import lombok.Getter;

@Getter
public class AlreadyExistsException extends RuntimeException{
    private final AlreadyExistsExceptionType alreadyExistsExceptionType;
    private final String detail;

    public AlreadyExistsException(AlreadyExistsExceptionType alreadyExistsExceptionType,String detail){
        super(alreadyExistsExceptionType.getMessage());
        this.alreadyExistsExceptionType=alreadyExistsExceptionType;
        this.detail=detail;
    }
    public AlreadyExistsException(AlreadyExistsExceptionType alreadyExistsExceptionType){
        super(alreadyExistsExceptionType.getMessage());
        this.alreadyExistsExceptionType=alreadyExistsExceptionType;
        this.detail=alreadyExistsExceptionType.getMessage();
    }
    public String toString(){
        return "AlreadyExistsException{"
                + "errorCode=" + alreadyExistsExceptionType.getErrorCode() +
                " , detail='" + detail + '\'' +
                '}';
    }
}
