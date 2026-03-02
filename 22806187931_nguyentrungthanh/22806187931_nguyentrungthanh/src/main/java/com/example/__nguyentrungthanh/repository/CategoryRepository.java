package com.example.__nguyentrungthanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.__nguyentrungthanh.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}