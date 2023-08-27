package com.example.demo.data.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.dao.ProductDao;
import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao{
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductDaoImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Product insertProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public Product selectProduct(Long number) {
		Product selectedProduct = productRepository.getById(number);
		
		return selectedProduct;
	}

	@Override
	public Product updateProductName(Long number, String name) throws Exception {
		Optional<Product> selectedProduct = productRepository.findById(number);
		
		Product updatedProduct;
		if(selectedProduct.isPresent()) {
			Product product = selectedProduct.get();
			
			product.setName(name);
			product.setUpdatedAt(LocalDateTime.now());
			
			updatedProduct = productRepository.save(product);
		} else {
			throw new Exception();
		}
		
		return updatedProduct;
	}

	@Override
	public void deleteProduct(Long number) throws Exception {
		Optional<Product> selectedProduct = productRepository.findById(number);
		if(selectedProduct.isPresent()) {
			Product product = selectedProduct.get();
			
			productRepository.delete(product);
		}else {
			throw new Exception();
		}
	}

	@Override
	public List<Product> findProductsByPriceGreaterThanEqual(int price) {
		List<Product> producs = productRepository.findProductsByPriceGreaterThanEqual(price);
		
		System.out.println("dao");
		System.out.println(producs);
		return producs;
	}
}
