package com.example.demo.data.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;

public interface ProductDao {
	List<Store> getNearStoreInfos(String productName); //수정 entity to dto
	List<Product> getProductsByStoreId(int storeId);

}
