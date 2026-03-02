package com.example.__nguyentrungthanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.__nguyentrungthanh.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}