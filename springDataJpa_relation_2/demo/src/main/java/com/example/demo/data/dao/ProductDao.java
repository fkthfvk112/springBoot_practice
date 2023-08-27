package com.example.demo.data.dao;

import java.util.List;

import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;

public interface ProductDao {
	List<Store> getNearStoreInfos(String productName);
}
