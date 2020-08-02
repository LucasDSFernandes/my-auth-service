package com.lucasdsf.api.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdsf.api.auth.domain.entity.ProfileUser;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileUser, Long> {

}
