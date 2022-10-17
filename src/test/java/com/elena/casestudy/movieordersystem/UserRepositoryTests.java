//package com.elena.casestudy.movieordersystem;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//import com.elena.casestudy.movieordersystem.entity.Role;
//import com.elena.casestudy.movieordersystem.entity.User;
//import com.elena.casestudy.movieordersystem.repository.UserRepository;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
//
//public class UserRepositoryTests {
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private TestEntityManager entityManager;
//	
//  @Test 
//	public void testCreateRoles() {
//		Role roleadmin=new Role("ROLE_AMDIN");
//		Role roleuser=new Role("ROLE_USER");
//		//entityManager(in the Spring Jpa test Class) proceed the objs into the db
//		entityManager.persist(roleadmin);
//		entityManager.persist(roleuser);
//	}
//	
////	@Test
////	public void testCreateNewUserOneRole() {
////		Role roleadmin =entityManager.find(Role.class, 1);
////		User user=new User("test@gmail.com","test");
////		user.addRole(roleadmin);
////		userRepository.save(user);
////	}
//	
//	
//}
