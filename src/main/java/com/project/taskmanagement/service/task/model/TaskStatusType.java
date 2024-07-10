package com.project.taskmanagement.service.task.model;

import lombok.Getter;

@Getter
public enum TaskStatusType {
    NEW("Yeni") ,
    IN_PROGRESS("Çalışıyor") ,
    COMPLETE("Tamamlandı");

    private final String label;

    TaskStatusType(String label){
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
    public static TaskStatusType fromString(String label) {
        for (TaskStatusType taskStatusType : TaskStatusType.values()) {
            if (taskStatusType.label.equalsIgnoreCase(label)) {
                return taskStatusType;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }
}
