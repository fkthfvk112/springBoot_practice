package com.example.demo.data.dao.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.data.dao.ProductDao;
import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;
import com.example.demo.data.repository.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao{
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductDaoImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Store> getNearStoreInfos(String productName) {
		List<Store> resultStores = productRepository.getNearStoreInfos(productName);
		
		return resultStores;
	}

	@Override
	public List<Product> getProductsByStoreId(int storeId) {
		List<Product> resultProducts = productRepository.getProductsByStoreId(storeId);
		
		return resultProducts;
	}

	@Override
	public Product saveProduct(Product product) {
		Product savedProduct = productRepository.save(product);
		System.out.println("----insert " + savedProduct);
		return null;
	}

//	@Override
//	public Product updateProductName(Long number, String name) throws Exception {
//		Optional<Product> selectedProduct = productRepository.findById(number);
//		
//		Product updatedProduct;
//		if(selectedProduct.isPresent()) {
//			Product product = selectedProduct.get();
//			
//			product.setName(name);
//			product.setUpdatedAt(LocalDateTime.now());
//			
//			updatedProduct = productRepository.save(product);
//		} else {
//			throw new Exception();
//		}
//		
//		return updatedProduct;
//	}
}
