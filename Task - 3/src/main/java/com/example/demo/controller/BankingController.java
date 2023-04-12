// Banking Controller
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Transaction;
import com.example.demo.models.User;
import com.example.demo.services.TransactionalService;
import com.example.demo.services.UserService;

/**
 * @author ashok class contains controllers to handle requests
 */
@Controller
// Parent Route
@RequestMapping("/api")
public class BankingController {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionalService transactService;

	/**
	 * method handles get request with /menu route
	 * 
	 * @return menupage
	 */
	@GetMapping("/menu")
	public String menuPage() {
		return "menupage";
	}

	/**
	 * method handles get request with /createuser route and return creates new user
	 * page
	 * 
	 * @param mandv
	 * @return mandv
	 */
	@GetMapping("/createuser")
	public ModelAndView createUserPage(ModelAndView mandv) {
		User user = new User();
		mandv.addObject("user", user);
		mandv.setViewName("createuser");
		return mandv;
	}

	/**
	 * method handles post request with /createuser route and creates new user and
	 * handles exception for null or empty values or existing values
	 * 
	 * @param user
	 * @param mandv
	 * @return mandv
	 */
	@PostMapping("/createuser")
	public ModelAndView submitUserPage(User user, ModelAndView mandv) {
		if (user.getId() == 0 || user.getName() == "" || user.getAmount() == 0) {
			mandv.addObject("msg", "Please Provide All The Fields");
			mandv.setViewName("successpage");
		}else if (user.getAmount() < 0) {
			mandv.addObject("msg", "Amount cannot be negative");
			mandv.setViewName("successpage");
		}else if (user.getId() < 0) {
			mandv.addObject("msg", "User Id cannot be negative");
			mandv.setViewName("successpage");
		} else {
			if (userService.findUserById(user.getId()) != null) {
				mandv.addObject("msg", "User " + user.getId() + " Already Exists");
				mandv.setViewName("successpage");
			} else {
				userService.createUser(user);
				mandv.addObject("msg", "User " + user.getId() + " Created Successfully");
				mandv.setViewName("successpage");
			}
		}
		return mandv;
	}

	/**
	 * method handles get request with /checkbalance route and returns checkbalance
	 * page
	 * 
	 * @param mandv
	 * @return mandv
	 */
	@GetMapping("/checkbalance")
	public ModelAndView checkBalancePage(ModelAndView mandv) {
		User user = new User();
		mandv.addObject(user);
		mandv.setViewName("checkbalance");
		return mandv;
	}

	/**
	 * method handles post request with /checkbalance route and returns balance and
	 * handles exception for null or empty values or not existing values
	 * 
	 * @param mandv
	 * @return mandv
	 */
	@PostMapping("/checkbalance")
	public ModelAndView checkBalance(User user, ModelAndView mandv) {
		if (user.getId() > 0) {
			if (userService.findUserById(user.getId()) == null) {
				mandv.addObject("msg", "Invalid User Id : " + user.getId());
				mandv.setViewName("successpage");
			} else {
				user = userService.findUserById(user.getId());
				mandv.addObject("id", user.getId());
				mandv.addObject("name", user.getName());
				mandv.addObject("amount", user.getAmount());
				mandv.setViewName("userdata");
			}
		} else {
			mandv.addObject("msg", "Invalid User Id : " + user.getId());
			mandv.setViewName("successpage");
		}
		return mandv;
	}

	/**
	 * method handles get request with /moneytransfer route and returns
	 * moneytransfer page
	 * 
	 * @param mandv
	 * @return mandv
	 */
	@GetMapping("/moneytransfer")
	public ModelAndView doBalanceTransferPage(ModelAndView mandv) {
		Transaction transaction = new Transaction();
		mandv.addObject(transaction);
		mandv.setViewName("moneytransfer");
		return mandv;
	}

	/**
	 * method handles post request with /moneytransfer route and returns success or
	 * failure message and handles exception for null or empty values or not
	 * existing values
	 * 
	 * @param transaction
	 * @param mandv
	 * @return mandv
	 */
	@PostMapping("/moneytransfer")
	public ModelAndView balanceTransfer(Transaction transaction, ModelAndView mandv) {
		try {
			transactService.moneyTransfer(transaction.getCrid(), transaction.getDrid(), transaction.getAmount());
			mandv.addObject("msg", "Amount Transferred Successfully");
		} catch (Exception e) {
			mandv.addObject("msg", e.getMessage());
		}
		mandv.setViewName("successpage");
		return mandv;
	}

	/**
	 * method handles get request with /users/{name} route and gets name as Path
	 * Variable
	 * 
	 * @param name
	 * @return ResponseEntity<List<User>>
	 */
	@GetMapping("/users/{name}")
	public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
		return ResponseEntity.ok(userService.findByName(name));
	}
}
