package com.fundamentos.platzi.springboot.Fundamentos;

import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBean;
import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithDependency;
import com.fundamentos.platzi.springboot.Fundamentos.Beans.MyBeanWithProperties;
import com.fundamentos.platzi.springboot.Fundamentos.components.ComponentDependency;
import com.fundamentos.platzi.springboot.Fundamentos.components.ComponentTwoImplement;
import com.fundamentos.platzi.springboot.Fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private ComponentDependency componentDependencyTwo;
	private MyBean myBean;

	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	private UserPojo userPojo;


	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  @Qualifier("componentImplement") ComponentDependency componentDependencyTwo,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.componentDependencyTwo = componentDependencyTwo;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args){
		componentDependency.saludar();
		componentDependencyTwo.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getAge()+" "+ userPojo.getEmail());
	}
}
