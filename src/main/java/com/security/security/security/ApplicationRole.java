package com.security.security.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.security.security.security.ApplicationRolePermission.*;

public enum ApplicationRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READE, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationRolePermission> permissionSet;

    ApplicationRole(Set<ApplicationRolePermission> permissionSet) {
        this.permissionSet = permissionSet;
    }
}
