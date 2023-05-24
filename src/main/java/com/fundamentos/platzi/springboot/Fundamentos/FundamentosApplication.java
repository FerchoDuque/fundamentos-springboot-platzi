package com.fundamentos.platzi.springboot.Fundamentos;

import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBean;
import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithDependency;
import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithProperties;
import com.fundamentos.platzi.springboot.Fundamentos.components.ComponentDependency;
import com.fundamentos.platzi.springboot.Fundamentos.components.ComponentTwoImplement;
import com.fundamentos.platzi.springboot.Fundamentos.entities.User;
import com.fundamentos.platzi.springboot.Fundamentos.pojo.UserPojo;
import com.fundamentos.platzi.springboot.Fundamentos.repositories.UserRepository;
import com.fundamentos.platzi.springboot.Fundamentos.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private ComponentDependency componentDependencyTwo;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	private UserService userService;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  @Qualifier("componentImplement") ComponentDependency componentDependencyTwo,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository,
								  UserService userService) {
		this.componentDependency = componentDependency;
		this.componentDependencyTwo = componentDependencyTwo;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		//ejemplosAnteriores();
		saveUsersInDB();
		getInformationJpqlFromUsers();
		saveWithErrorTransactional();
	}

	private void saveWithErrorTransactional(){
		User user1 = new User("TestTransactional1", "TestTransactional@test.com", LocalDate.of(2023, 03, 10));
		User user2 = new User("TestTransactional2", "TestTransactional@test.com", LocalDate.of(2023, 03, 10));
		User user3 = new User("TestTransactional3", "TestTransactional@test.com", LocalDate.of(2023, 03, 10));
		List<User> users = Arrays.asList(user1, user2, user3);

		userService.saveTransactional(users);

		userService.getAllUsers().stream().forEach(user -> LOGGER.info("Usuario de transactional: " + user));
	}

	private void getInformationJpqlFromUsers(){
		LOGGER.info("Usuario encontrado!: " +
				userRepository.findByUserEmail("john1@test.com")
						.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

		userRepository.findAndSort("John", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario encontrado:" + user));

		userRepository.findByName("John1")
				.stream()
				.forEach(user -> LOGGER.info("Usuario Query method: "+ user.toString()));

		LOGGER.info("Usuario Query method findByNameAndEmail: "+userRepository.findByNameAndEmail("John1", "john1@test.com")
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

		userRepository.findByNameLike("%John%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario like: " + user));

		userRepository.findByNameOrEmail(null, "john1@test.com")
				.stream()
				.forEach(user -> LOGGER.info("Usuario Or: " + user));

		userRepository.findByBirthDateBetween(LocalDate.of(1900, 1, 1), LocalDate.now())
				.stream()
				.forEach(user -> LOGGER.info("Usuario Between: " + user));

		userRepository.findByNameOrderByIdDesc("John1")
				.stream()
				.forEach(user -> LOGGER.info("Usuario order By: " + user));

		userRepository.findByNameLikeOrderByIdDesc("%John%")
				.stream()
				.forEach(user -> LOGGER.info("Usuario like order By: " + user));

		userRepository.findByNameContainingOrderByIdDesc("J")
				.stream()
				.forEach(user -> LOGGER.info("Usuario Contain order By: " + user));

		LOGGER.info("Usuario named parameter: " + userRepository.getAllByBirthDateAndEmail( LocalDate.of(2023, 03, 10), "john1@test.com")
				.orElseThrow(() -> new RuntimeException("No encontro usuario getAllByBirthDateAndEmail")));

	}

	private void saveUsersInDB(){
		User user1 = new User("John1", "john1@test.com", LocalDate.of(2023, 03, 10));
		User user2 = new User("John1", "john2@test.com", LocalDate.of(2023, 03, 10));
		User user3 = new User("John3", "john3@test.com", LocalDate.of(2023, 03, 10));
		User user4 = new User("John4", "john4@test.com", LocalDate.of(2023, 03, 10));
		List<User> userList = Arrays.asList(user1, user2, user3, user4);

		userList.forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		componentDependencyTwo.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getAge()+" "+ userPojo.getEmail());
		// Simulacion de error para generar logs de error...
		try{
			int i = 8/0;
		}catch (Exception e){
			LOGGER.error("Mensaje de Error de mi app..." + e.toString());
		}
	}
}
