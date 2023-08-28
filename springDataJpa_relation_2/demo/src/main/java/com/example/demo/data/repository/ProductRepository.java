package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Product;
import com.example.demo.data.entity.Store;

public interface ProductRepository extends JpaRepository<Product, Long>{
	 @Query("SELECT s "
	            + "FROM Store s "
	            + "WHERE s.storeId IN ( "
	            + "    SELECT sp.store.storeId "
	            + "    FROM Product p "
	            + "    JOIN StoreProduct sp ON p.productId = sp.product.productId "
	            + "    WHERE p.productTitle = :productName) "
	            )
	List<Store> getNearStoreInfos(@Param("productName") String productName);
	 
	 @Query("SELECT sp.product "
		       + "FROM StoreProduct AS sp "
		       + "WHERE sp.store.storeId = :storeId")
	List<Product> getProductsByStoreId(@Param("storeId") int storeId);
	 
	
}
