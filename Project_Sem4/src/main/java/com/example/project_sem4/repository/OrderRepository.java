package com.example.project_sem4.repository;

import com.example.project_sem4.entity.Order;
import com.example.project_sem4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

