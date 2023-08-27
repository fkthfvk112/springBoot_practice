package com.example.demo.service;

import java.util.List;

import com.example.demo.data.dto.StoreDto;
import com.example.demo.data.entity.Store;

public interface ProductService {
	List<Store> getNearStoreInfos(String productName);
//	ProductResponseDto getProduct(Long number);
//	ProductResponseDto saveProduct(ProductDto productDto);
//	ProductResponseDto changeProductName(Long number, String name) throws Exception;
//	void deleteProduct(Long number) throws Exception;
//	List<ProductResponseDto> findProductsByPriceGreaterThanEqual(int price);
}
