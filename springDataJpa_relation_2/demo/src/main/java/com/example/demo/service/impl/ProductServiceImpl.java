package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.ProductDao;
import com.example.demo.data.dto.StoreDto;
import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}//엔티티 객체 DTO객체 전환
	
	@Override
	public List<Store> getNearStoreInfos(String productName){
		List<Store> stores = productDao.getNearStoreInfos(productName);
		
		return stores;
	}

	@Override
	public List<Product> getProductsByStoreId(int storeId) {
		List<Product> Products = productDao.getProductsByStoreId(storeId);
		
		return Products;
	}
	
	
	//전환 예제
//	@Override
//	public ProductResponseDto getProduct(Long number) {
//		Product product = productDao.selectProduct(number);//db to entity
//		
//		ProductResponseDto productResponseDto = new ProductResponseDto();//dto 생성
//		productResponseDto.setNumber(product.getNumber());//entity to dto
//		productResponseDto.setName(product.getName());
//		productResponseDto.setPrice(product.getPrice());
//		productResponseDto.setStock(product.getStock());
//		
//		return productResponseDto;
//	}

}
