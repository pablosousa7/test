package com.udacity.store.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Product product;
}
