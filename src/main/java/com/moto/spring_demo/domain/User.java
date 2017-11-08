package com.moto.spring_demo.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="user")
public class User extends BaseEntity implements UserDetails{

    @Size(max = 32)
    private String name;

    @Size(max = 32, message = "username is too long")
    @Column(unique = true)
    private String username;

    @Size(min= 3, message = "password is too short")
    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "user")
    @Fetch(FetchMode.SELECT)
    private List<UserRole> userRoles;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "user")
    @Fetch(FetchMode.SELECT)
    private List<Task>tasks ;

    @ManyToOne
    private Company company;

    /*
     - there are many approach. but the approach i am following
     - need add some extra properties for spring security
     */

    private boolean enabled = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired = true;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        this.userRoles.forEach(r -> {
            authorityList.add(new SimpleGrantedAuthority(r.getAuthority()));
        });
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public List<UserRole> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<UserRole> roles) {
//        this.roles = roles;
//    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username +
                '}';
    }
}
