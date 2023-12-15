package com.indiumsoft.ordermicroservice.repository;

import com.indiumsoft.ordermicroservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
