package com.simpliLearn.loginAuth;

import static org.assertj.core.api.Assertions.assertThat;

import com.simpliLearn.loginAuth.Domain.User;
import com.simpliLearn.loginAuth.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private UserRepository repo;

	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("testing.first@test.com");
		user.setPassword("testing1");
		user.setFirstName("User1");
		user.setLastName("Testing");
		//Save data to DB
		User savedUser = repo.save(user);
		//Get the user saved
		User existUser = entityManager.find(User.class, savedUser.getId());
		//Test
		assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
		
	}

	@Test
	public void testFindByEmail() {
		String email = "testing.first@test.com";
		User user = repo.findByEmail(email);
		
		assertThat(user.getEmail()).isEqualTo(email);
	}

}
