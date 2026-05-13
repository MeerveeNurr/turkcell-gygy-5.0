package com.turkcell.spring_cqrs.core.security.context;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.turkcell.spring_cqrs.core.security.authorization.Role;

@Component
@RequestScope // Her HTTP isteği için yeni bir UserContext oluşturulur.
public class UserContext {

    private String userId;
    private String email;
    private List<Role> roles;

    public void setUser(String userId, String email,List<Role> roles) {
        this.userId = userId;
        this.email = email;
        this.roles = roles;
    }
    public void clear() {
        this.userId = null;
        this.email = null;
        this.roles = null;
    }

    public boolean isAuthenticated() {

        return userId != null;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public List<Role> getRoles() {
        return roles;
    }
}