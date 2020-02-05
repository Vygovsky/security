package com.security.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.security.security.security.ApplicationRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user_Anna = User.builder()
                .username("anna")
                .password(passwordEncoder.encode("123"))
                //      .roles(STUDENT.name())
                .authorities(STUDENT.grantedAuthorities())
                .build();

        UserDetails adminRoman = User.builder()
                .username("roman")
                .password(passwordEncoder.encode("admin"))
                //      .roles(ADMIN.name())
                .authorities(ADMIN.grantedAuthorities())
                .build();


        UserDetails user_Tom = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("tom"))
                //    .roles(ADMINTRAINEE.name())
                .authorities(ADMINTRAINEE.grantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(user_Anna, adminRoman, user_Tom);
    }

}
