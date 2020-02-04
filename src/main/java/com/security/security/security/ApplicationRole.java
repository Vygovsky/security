package com.security.security.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.security.security.security.ApplicationRolePermission.*;

public enum ApplicationRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READE, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READE, STUDENT_READ));

    public Set<ApplicationRolePermission> getPermissionSet() {
        return permissionSet;
    }

    private final Set<ApplicationRolePermission> permissionSet;

    ApplicationRole(Set<ApplicationRolePermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissionSet()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
