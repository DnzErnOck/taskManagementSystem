package com.project.taskmanagement.service.user.model;

import lombok.Getter;

@Getter
public enum RoleType {
    USER("Kullanıcı"),

    ADMIN("Admin");

    private String label;

    RoleType(String label){
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

    public static RoleType fromString(String label) {
        for (RoleType roleType : RoleType.values()) {
            if (roleType.label.equalsIgnoreCase(label)) {
                return roleType;
            }
        }
        throw new IllegalArgumentException("No enum constant with label " + label);
    }
}
