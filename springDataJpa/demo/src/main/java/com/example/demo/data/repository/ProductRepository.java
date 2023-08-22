package com.example.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.example.demo.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
