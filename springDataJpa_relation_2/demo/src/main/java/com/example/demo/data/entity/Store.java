package com.example.demo.data.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	
	@Column(name="store_address")
	private String storeAddress;
	
//	@OneToOne
//	@Column(name="member_id")
//	private String memberId;
	
	//양방향 매핑, entity를 dto로 변환하여야 무한루프 탈출 가능
//	@ToString.Exclude//ToString에서 제외, 제외 안하면 무한 호출 에러
//	@OneToMany(mappedBy ="store")
//	private List<StoreProduct> storeProducts;
}
