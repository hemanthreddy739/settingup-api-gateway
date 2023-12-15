package com.indiumsoft.ordermicroservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders_table")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private int orderId;
    private String name;

    private int qty;
    private double price;

}
