package com.moto.spring_demo.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="company")
public class Company extends BaseEntity {

    @NotBlank
    private String name;

    private String address;

    @ManyToMany(mappedBy = "companies")
    private List<Client> clients;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
    private List<User> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
