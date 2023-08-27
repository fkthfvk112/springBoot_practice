package com.example.demo.data.dto;

import java.util.List;

import com.example.demo.data.entity.StoreProduct;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class StoreDto {
	private int storeId;
	private String storeAddress;
	private List<StoreProduct> storeProducts;
}
