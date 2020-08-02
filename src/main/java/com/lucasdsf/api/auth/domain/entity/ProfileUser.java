package com.lucasdsf.api.auth.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lucasdsf.api.auth.enums.ProfileEnums;

@Entity
@Table(name = "tbg_perfil_usuario")
public class ProfileUser {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_perfil")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_perfil", nullable = false)
	private ProfileEnums descriptionProfile;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProfileEnums getDescriptionProfile() {
		return descriptionProfile;
	}
	public void setDescriptionProfile(ProfileEnums descriptionProfile) {
		this.descriptionProfile = descriptionProfile;
	}
	
}
