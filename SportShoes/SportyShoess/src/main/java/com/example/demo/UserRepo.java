package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo  extends JpaRepository<User,Integer>  {

	@Query("select User from User User where User.username=?1")
	public User findbyusername(String username);
	@Query("select User from User User where User.password=?1")
	public User findbypassword(String password);

	@Query("delete from User user where user.id=?1")
	public User deletebyid(int id);
	
}

