package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api")
public class BankingController {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionalService transactService;

	@GetMapping("/menu")
	public String menuPage() {
		return "menupage";
	}

	@GetMapping("/createuser")
	public ModelAndView createUserPage(ModelAndView mandv) {
		User user = new User();
		mandv.addObject("user", user);
		mandv.setViewName("createuser");
		return mandv;
	}

	@PostMapping("/createuser")
	public ModelAndView submitUserPage(User user, ModelAndView mandv) {
		userService.createUser(user);
		mandv.addObject("msg", "User Created Successfully");
		mandv.setViewName("successpage");
		return mandv;
	}

	@GetMapping("/checkbalance")
	public ModelAndView checkBalancePage(ModelAndView mandv) {
		User user = new User();
		mandv.addObject(user);
		mandv.setViewName("checkbalance");
		return mandv;
	}

	@PostMapping("/checkbalance")
	public ModelAndView checkBalance(User user, ModelAndView mandv) {
		if (user.getId() > 0) {
			user = userService.findUserById(user.getId());
			mandv.addObject("id", user.getId());
			mandv.addObject("name", user.getName());
			mandv.addObject("amount", user.getAmount());
			mandv.setViewName("userdata");
		} else {
			mandv.addObject("msg", "Invalid User Id");
			mandv.setViewName("successpage");
		}
		return mandv;
	}

	@GetMapping("/moneytransfer")
	public ModelAndView doBalanceTransferPage(ModelAndView mandv) {
		Transaction transaction = new Transaction();
		mandv.addObject(transaction);
		mandv.setViewName("moneytransfer");
		return mandv;
	}

	@PostMapping("/moneytransfer")
	public ModelAndView balanceTransfer(Transaction transaction, ModelAndView mandv) {
		try {
			transactService.moneyTransfer(transaction.getCrid(), transaction.getDrid(), transaction.getAmount());
			mandv.addObject("msg", "Amount Transferred Successfully");
		} catch (TransactionalException e) {
			mandv.addObject("msg", "Transaction Failed");
		}
		mandv.setViewName("successpage");
		return mandv;
	}

	@GetMapping("/users/{name}")
	public ResponseEntity<List<User>> getUsersByName(@PathVariable String name) {
		return ResponseEntity.ok(userService.findByName(name));
	}
}
