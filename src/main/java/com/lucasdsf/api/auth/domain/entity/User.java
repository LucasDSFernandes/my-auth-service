package com.lucasdsf.api.auth.domain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_usuario")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="primeiro_nome", nullable = false)
	private String firstName;
	
	@Column(name="ultimo_nome", nullable = false)
	private String lastName;

	@Column(name="nm_login", nullable = false)
	private String userLogin;
	
	@Column(name="email", nullable = false)
	private String email;

	@Column(name="telefone", nullable = false)
	private Long phoneNumber;

	@Column(name="dt_aniversario", nullable = true)
	private LocalDate birthday;
	
	@Column(name="cd_senha", nullable = false)
	private String password;
	
	@OneToOne(fetch= FetchType.EAGER)
	@JoinColumn(name = "id_perfil")
	private ProfileUser profile;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Vehicle> vehicle;
	
	@Column(name="dh_ultimo_acesso")
	private LocalDateTime lastLogin;
	
	@Column(name="dh_creacao", nullable = false)
	private LocalDateTime createdAt;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ProfileUser getProfile() {
		return profile;
	}
	public void setProfile(ProfileUser profile) {
		this.profile = profile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}