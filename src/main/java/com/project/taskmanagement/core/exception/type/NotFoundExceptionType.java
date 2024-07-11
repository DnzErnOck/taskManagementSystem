package com.project.taskmanagement.core.exception.type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotFoundExceptionType {

    USER_DATA_NOT_FOUND(2000,"Kullanıcı mevcut değil"),
    USER_LIST_NOT_FOUND(2001, "Kullanıcı listesi mevcut değil"),
    ADMIN_DATA_NOT_FOUND(2002, "Çalışan mevcut değil"),
    ADMIN_LIST_NOT_FOUND(2003, "Çalışan listesi mevcut değil"),


    TASK_DATA_NOT_FOUND(2006, "Ürün mevcut değil"),
    TASK_LIST_NOT_FOUND(2007, "Ürün listesi mevcut değil"),
    EMAIL_ADDRESS_DATA_NOT_FOUND(2011, "Email adresi mevcut değil"),
    USER_ROLE_NOT_FOUND(2013, "Kullanıcı rolü mevcut değil");

    private final Integer errorCode;
    private final String message;
}
