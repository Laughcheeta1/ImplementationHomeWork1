package com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Client;

import java.util.Optional;

public interface ClientDao extends JpaRepository<Client, Long> {
    public Optional<Client> findByEmail(String email);
    public Optional<Client> findByPhoneNumber(String phoneNumber);
}
