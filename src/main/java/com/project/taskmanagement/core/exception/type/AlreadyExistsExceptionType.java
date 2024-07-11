package com.project.taskmanagement.core.exception.type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlreadyExistsExceptionType {
    USER_ALREADY_EXISTS(2001,"Kullanıcı zaten mevcut"),
    ROLE_ALREADY_EXISTS(2002,"Role zaten mevcut");

    private  final Integer errorCode;
    private final String message;
}
