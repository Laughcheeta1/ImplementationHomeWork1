package com.implementacioneintegracion.Trabajo_Clase_1.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Purchase")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="purchase_date")
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name="client_id", referencedColumnName="id")
    private Client client;

    @OneToMany(mappedBy = "purchase")
    @JsonIgnore
    private List<ProductPurchase> productPurchase;


}
