package com.project.taskmanagement.core.exception;

import com.project.taskmanagement.core.exception.type.NotFoundExceptionType;
import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{
    private final NotFoundExceptionType notFoundExceptionType;
    private final String detail;

    public NotFoundException(NotFoundExceptionType notFoundExceptionType, String detail){
        super(notFoundExceptionType.getMessage());
        this.notFoundExceptionType = notFoundExceptionType;
        this.detail = detail;
    }

    public NotFoundException(NotFoundExceptionType notFoundExceptionType){
        super(notFoundExceptionType.getMessage());
        this.notFoundExceptionType = notFoundExceptionType;
        this.detail = notFoundExceptionType.getMessage();
    }

    public String toString(){
        return "NotFoundException{" +
                "error code = " + notFoundExceptionType.getErrorCode() +
                ", detail = " + detail + "}";
    }
}
