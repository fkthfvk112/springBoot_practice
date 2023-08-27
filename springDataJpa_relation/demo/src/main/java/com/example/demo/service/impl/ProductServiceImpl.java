package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.ProductDao;
import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.dto.ProductResponseDto;
import com.example.demo.data.entity.Product;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	private final ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}//엔티티 객체 DTO객체 전환
	
	@Override
	public ProductResponseDto getProduct(Long number) {
		Product product = productDao.selectProduct(number);//db to entity
		
		ProductResponseDto productResponseDto = new ProductResponseDto();//dto 생성
		productResponseDto.setNumber(product.getNumber());//entity to dto
		productResponseDto.setName(product.getName());
		productResponseDto.setPrice(product.getPrice());
		productResponseDto.setStock(product.getStock());
		
		return productResponseDto;
	}

	@Override
	public ProductResponseDto saveProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setStock(productDto.getStock());
		product.setCreateAt(LocalDateTime.now());
		product.setUpdatedAt(LocalDateTime.now());//dto to entity
		
		Product savedProduct = productDao.insertProduct(product);//entity save
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setNumber(savedProduct.getNumber());
		productResponseDto.setName(savedProduct.getName());
		productResponseDto.setPrice(savedProduct.getPrice());
		productResponseDto.setStock(savedProduct.getStock());
		
		
		return productResponseDto;
	}

	@Override
	public ProductResponseDto changeProductName(Long number, String name) throws Exception {
		Product changedProduct = productDao.updateProductName(number, name);
		
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setNumber(changedProduct.getNumber());
		productResponseDto.setName(changedProduct.getName());
		productResponseDto.setPrice(changedProduct.getPrice());
		productResponseDto.setStock(changedProduct.getStock());
		
		return productResponseDto;
	}

	@Override
	public void deleteProduct(Long number) throws Exception {
		productDao.deleteProduct(number);
		
	}

	@Override
	public List<ProductResponseDto> findProductsByPriceGreaterThanEqual(int price) {
		List<ProductResponseDto> productDtos = new ArrayList<>();

		
		List<Product> products = productDao.findProductsByPriceGreaterThanEqual(price);
		
		for(Product product:products) {
			ProductResponseDto productResponseDto = new ProductResponseDto();
			productResponseDto.setNumber(product.getNumber());
			productResponseDto.setName(product.getName());
			productResponseDto.setPrice(product.getPrice());
			productResponseDto.setStock(product.getStock());
			productDtos.add(productResponseDto);
		}
		
		return productDtos;
	}
	

}
