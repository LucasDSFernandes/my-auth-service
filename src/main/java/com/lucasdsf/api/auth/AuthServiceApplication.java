package com.lucasdsf.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.lucasdsf.api.auth.domain.repository.ProfileRepository;
import com.lucasdsf.api.auth.domain.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServiceApplication {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProfileRepository profileRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			String password = PasswordUtil.generateBCrypt("tw060686");
//			User userEntity = new User();
//			userEntity.setUserLogin("admin");
//			userEntity.setFirstName("lucas");
//			userEntity.setFullName("lucas dos santos fernandes");
//			userEntity.setEmail("teste@email.com");
//			userEntity.setPassword(PasswordUtil.generateBCrypt("lucasdsf123"));
//			
//			ProfileUser profile = new ProfileUser();
//			profile.setDescriptionProfile(ProfileEnums.ROLE_MASTER);
//			
//			userEntity.setProfile(profile);
//			this.profileRepository.save(profile);
//			this.userRepository.save(userEntity);
//
//		};
//	}

}
