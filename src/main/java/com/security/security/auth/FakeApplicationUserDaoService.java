package com.security.security.auth;
import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.security.security.security.ApplicationRole.ADMIN;
import static com.security.security.security.ApplicationRole.ADMINTRAINEE;
import static com.security.security.security.ApplicationRole.STUDENT;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(userApplication -> username.equals(userApplication.getUsername()))
                .findFirst();
    }


    public List<ApplicationUser> getApplicationUsers() {

        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("anna",
                        passwordEncoder.encode("anna"),
                        STUDENT.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser("roman",
                        passwordEncoder.encode("admin"),
                        ADMIN.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser("tom",
                        passwordEncoder.encode("tom"),
                        ADMINTRAINEE.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true)
        );
        return applicationUsers;
    }
}
