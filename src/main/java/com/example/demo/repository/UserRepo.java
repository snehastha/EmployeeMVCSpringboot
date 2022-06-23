package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	

	User findByUsernameAndPassword(String un ,String psw);

	@Query(value ="select * from user_tbl where username =:un and password = :psw ",nativeQuery=true)
	 User userlogin(@Param("un")String un , @Param("psw")String psw);
}
