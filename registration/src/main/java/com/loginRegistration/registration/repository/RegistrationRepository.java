package com.loginRegistration.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginRegistration.registration.entity.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);

	User findByEmailIdAndPassword(String emailId, String password);

}
