package com.basic.demo.Repository.PoJo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;

    @Column(name = "address")
    private String address_line_1;

    @Column(name = "address2")
    private String address_line_2;

    @Column(name = "district")
    private String district;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phone")
    private String phone;
}
