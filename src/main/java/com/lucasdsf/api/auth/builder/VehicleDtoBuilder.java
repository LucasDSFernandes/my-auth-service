package com.lucasdsf.api.auth.builder;

import com.lucasdsf.api.auth.domain.model.VehicleDto;

public class VehicleDtoBuilder {
	private Long id;
	private Long year;
	private String licensePlate;
	private String model;
	private String color;
	
	public static VehicleDtoBuilder vehicleDTOBuilder() {
		return new VehicleDtoBuilder();
	}
	
	public VehicleDtoBuilder id(Long id) {
		this.id = id;
		return this;		
	}
	public VehicleDtoBuilder year(Long year) {
		this.year = year;
		return this;		
	}
	public VehicleDtoBuilder licensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;		
	}
	public VehicleDtoBuilder model(String model) {
		this.model = model;
		return this;		
	}
	public VehicleDtoBuilder color(String color) {
		this.color = color;
		return this;		
	}
	
	
	public VehicleDto build() {
		VehicleDto vehicleDto = new VehicleDto();
		vehicleDto.setId(id);
		vehicleDto.setLicensePlate(licensePlate);
		vehicleDto.setModel(model);
		vehicleDto.setYear(year);
		vehicleDto.setColor(color);
		return vehicleDto;
	} 

}
