package com.example.demo.data.dto;

public class ChangeProductNameDto {
	private long number;
	private String name;
	public ChangeProductNameDto(long number, String name) {
		super();
		this.number = number;
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
