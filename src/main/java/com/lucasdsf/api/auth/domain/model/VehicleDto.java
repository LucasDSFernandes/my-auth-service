package com.lucasdsf.api.auth.domain.model;

public class VehicleDto {
	
	private Long id;
	private Long year;
	private String licensePlate;
	private String model;
	private String color;
	private String message;
	private Boolean sucess;

	public VehicleDto() {}
	public VehicleDto(String message, boolean sucess) {
		this.message = message;
		this.sucess = sucess;
	}
	
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean isSucess() {
		return sucess;
	}
	public void setSucess(Boolean sucess) {
		this.sucess = sucess;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
