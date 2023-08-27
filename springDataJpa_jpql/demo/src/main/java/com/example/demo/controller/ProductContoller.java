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

import com.example.demo.data.dto.ChangeProductNameDto;
import com.example.demo.data.dto.ProductDto;
import com.example.demo.data.dto.ProductResponseDto;
import com.example.demo.data.entity.Product;
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
	public ResponseEntity<ProductResponseDto> getProduct(Long number){
		System.out.println("getProduct");
		ProductResponseDto productResponseDto = productService.getProduct(number);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}
	
	@GetMapping("/price")
	public List<ProductResponseDto> findProductsByPriceGreaterThanEqual(int price){
		 System.out.println("findProductsByPriceGreaterThanEqual");
		 List<ProductResponseDto> dtos = productService.findProductsByPriceGreaterThanEqual(price);
		 System.out.println(dtos);
		 
		 return dtos;
	}
	
	@PostMapping()
	public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto){
		System.out.println("createProduct");
		ProductResponseDto productResponseDto = productService.saveProduct(productDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
	}
	
	@PutMapping()
	public ResponseEntity<ProductResponseDto> changeProductName(
			@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception{
		ProductResponseDto productResponseDto = productService.changeProductName(
				changeProductNameDto.getNumber(),
				changeProductNameDto.getName());
		
		return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);	
	}
	
	@DeleteMapping()
	public ResponseEntity<String> deleteProduct(Long number) throws Exception{
		productService.deleteProduct(number);
		
		return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
	}

}
