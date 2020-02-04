package com.security.security.security;

public enum ApplicationRolePermission {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    COURSE_WRITE("course:write"),
    COURSE_READE("course:read");

    private final String permission;

    ApplicationRolePermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
