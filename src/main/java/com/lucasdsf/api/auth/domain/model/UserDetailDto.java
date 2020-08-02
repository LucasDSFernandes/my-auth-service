package com.lucasdsf.api.auth.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lucasdsf.api.auth.domain.entity.User;

public class UserDetailDto implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Long phone;
	private LocalDate birthday;
	private LocalDateTime createdAt;
	private LocalDateTime lastLogin;
	private List<VehicleDto> cars;
	private Collection<? extends GrantedAuthority> authoritiesRoles;


	public UserDetailDto(){}
	public UserDetailDto(User user, List<VehicleDto> vehicle, Collection<? extends GrantedAuthority> authorities) {
		this.setId(user.getId());
		this.setLogin(user.getUserLogin());
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.phone = user.getPhoneNumber();
		this.birthday = user.getBirthday();
		this.setCreatedAt(user.getCreatedAt());
		this.cars = vehicle;
		this.authoritiesRoles = authorities;
		this.setLastLogin(user.getLastLogin());
	}

	@Override
	public String getUsername() {
		return getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authoritiesRoles;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public List<VehicleDto> getCars() {
		return cars;
	}
	public void setCars(List<VehicleDto> cars) {
		this.cars = cars;
	}
	
}