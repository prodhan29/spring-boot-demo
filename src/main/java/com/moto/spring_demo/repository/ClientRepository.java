package com.moto.spring_demo.repository;

import com.moto.spring_demo.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nahid on 11/6/17.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
