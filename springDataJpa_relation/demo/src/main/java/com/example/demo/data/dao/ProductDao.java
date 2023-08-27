package com.example.demo.data.dao;

import java.util.List;

import com.example.demo.data.entity.Product;

public interface ProductDao {
	Product insertProduct(Product product);
	Product selectProduct(Long number);
	Product updateProductName(Long numver, String name) throws Exception;
	void deleteProduct(Long number) throws Exception;
	List<Product> findProductsByPriceGreaterThanEqual(int price);
}
