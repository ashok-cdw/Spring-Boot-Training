// Banking Application
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ashok
 *
 */
@SpringBootApplication(scanBasePackages = { "com.models", "com.example.demo" })
@EnableJpaRepositories(basePackageClasses = com.example.demo.models.UserDAO.class)
@EntityScan(basePackageClasses = com.example.demo.models.User.class)
public class BankingApplication {

	/**
	 * main method invokes the run method in SpringApplication
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

}
