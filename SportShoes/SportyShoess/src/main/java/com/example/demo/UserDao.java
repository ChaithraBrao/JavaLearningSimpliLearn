package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserDao {

	@Autowired
    UserRepo repo;
	
	
		


		public User insert(User u) {
			// TODO Auto-generated method stub
			return repo.save(u);
		}

		
		
		public List<User> getall(){
			return repo.findAll();
		}
		
		public User update(User s) {
	
			
			User pp=repo.findById(s.getId()).orElse(null);
            pp.setAddress(s.getAddress());
			
			return repo.save(pp);

		}
		
		
		public void deleteByid(int id) {
			repo.deleteById(id);
			
		}
	
}
