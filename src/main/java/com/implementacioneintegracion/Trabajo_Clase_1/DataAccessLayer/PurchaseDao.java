package com.implementacioneintegracion.Trabajo_Clase_1.DataAccessLayer;

import com.implementacioneintegracion.Trabajo_Clase_1.Models.Purchase;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseDao extends JpaRepository<Purchase, Long> {
    public Optional<List<Purchase>> findByClientId(Long clientId);
}
