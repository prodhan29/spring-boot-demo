package com.moto.spring_demo.domain;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity{

    @Column(name = "roles")
    private String authority;

    @ManyToOne
    private User user;


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
