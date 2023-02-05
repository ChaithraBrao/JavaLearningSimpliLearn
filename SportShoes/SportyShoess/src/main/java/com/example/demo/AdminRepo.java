package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo   extends JpaRepository<Admin,Integer> {
	
	 //                table     pojo  table       table.coloumnname
		@Query("select Admin from Admin Admin where Admin.username=?1")
		public Admin findbyusername(String username);
		
		
		@Query("select Admin from Admin Admin where Admin.password=?1")
		public Admin findbypassword(String password);



}

