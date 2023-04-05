package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.models.AccountsDAO;
import com.models.MyService;
import com.models.TransactionService;

@SpringBootApplication
public class Springdemo3Application {

	public static void main(String[] args) throws InsufficientBalance {
		ConfigurableApplicationContext context = SpringApplication.run(Springdemo3Application.class, args);
//		AccountsDAO dao = context.getBean("acedao", AccountsDAO.class);
//		MyService service = context.getBean("MyService",MyService.class);
//		service.doServe(100, 1000);
		TransactionService tssService = context.getBean("tss",TransactionService.class);
		tssService.moneyTransfer(100, 200, 1000);
	}

}
