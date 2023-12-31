package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;
import com.example.demo.service.ProductService;


@RequestMapping("/product")
@RestController
public class ProductContoller {
	private final ProductService productService;
	
	@Autowired
	public ProductContoller(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping()
	public List<Store> getNearStoreInfos(String productName) {
		System.out.println("-----getNearStoreInfos");
		
		List<Store> stores = productService.getNearStoreInfos(productName);
		System.out.println(stores);
	
		return stores;
	}
	
	@GetMapping("/product-list")
	public List<Product> getProductsByStoreId(int storeId) {
		System.out.println("-----getProductsByStoreId");
		
		List<Product> products = productService.getProductsByStoreId(storeId);
		System.out.println(products);
	
		return products;
	}
	
	@PostMapping("/add-product")
	public void insertProduct(@RequestBody Product product) {
		System.out.println("-----insertProduct");
		
		productService.saveProduct(product);
		
	}
	

}
