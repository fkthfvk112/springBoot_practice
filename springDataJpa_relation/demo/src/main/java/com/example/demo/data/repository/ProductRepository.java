package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("SELECT p FROM Product as p WHERE p.price >= :price")
	List<Product> findProductsByPriceGreaterThanEqual(@Param("price") int price);
}
