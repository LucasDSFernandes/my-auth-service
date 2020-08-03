package com.lucasdsf.api.auth.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucasdsf.api.auth.builder.VehicleDtoBuilder;
import com.lucasdsf.api.auth.domain.entity.User;
import com.lucasdsf.api.auth.domain.entity.Vehicle;
import com.lucasdsf.api.auth.domain.model.UserDetailDto;
import com.lucasdsf.api.auth.domain.model.VehicleDto;
import com.lucasdsf.api.auth.domain.repository.UserRepository;
import com.lucasdsf.api.auth.enums.ProfileEnums;

@Service(value = "userService")
@Transactional(rollbackOn=Exception.class)
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		return loadUserByLogin(username);
	}
	
	public UserDetailDto loadUserByLogin(String username) {
		return this.create(userRepository.findFirstByUserLogin(username)
				.orElseThrow(()->new UsernameNotFoundException("Usuario e senha inválido")));
	}
	
	public UserDetailDto create(User user) {
		user.setLastLogin(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).toLocalDateTime());
		userRepository.save(user);
		return new UserDetailDto(user,getBuildLisVehicle(user),mapToGrantedAuthorities(user.getProfile().getDescriptionProfile()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnums profilesEnum) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(profilesEnum.toString()));
		return authorities;
	}
	private List<VehicleDto> getBuildLisVehicle(User user) {
		List<VehicleDto> vehicleList = new ArrayList<>();

		List<Vehicle> vehicles = user.getVehicle();
		vehicles.forEach(vehicle ->{
			vehicleList.add(VehicleDtoBuilder.vehicleDTOBuilder()
									.id(vehicle.getId())
									.color(vehicle.getColor())
									.licensePlate(vehicle.getLicensePlate())
									.model(vehicle.getModel())
									.year(vehicle.getYear())
									.build());
				
		});
		return vehicleList;
	}
}