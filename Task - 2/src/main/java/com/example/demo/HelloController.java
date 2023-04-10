package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "hello")
public class HelloController {
	@GetMapping
	public void sayHai() {
		System.out.println("Hai...We are from CDW");
	}

	@GetMapping("hello2")
	public String sayHai2() {
		System.out.println("Hellooo222.....");
		return "welcome";
	}

	@GetMapping("hello3")
	public ResponseEntity<String> sayHai3() {
		return ResponseEntity.ok("This is a response from ResponseEntity");
	}

	@GetMapping("hello4")
	public ModelAndView sayHai4() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView");
		mv.setViewName("welcome");
		return mv;
	}

	@GetMapping("hello5")
	public ModelAndView sayHai5(ModelAndView mv) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....Injected by View Resolver");
		mv.setViewName("welcome");
		return mv;
	}

	@GetMapping("hello6")
	public ModelAndView sayHai6(ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....Injected by View Resolver");
		mv.setViewName("welcome");
		request.setAttribute("hello1", "hello world hello world hello world");

		HttpSession session = request.getSession();
		session.setAttribute("hello2", "session session session");
		return mv;
	}

	@GetMapping("repeat")
	public ModelAndView repeat(ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....repeat repeat repeat");
		mv.setViewName("welcome");
		request.setAttribute("hello1", "repeat repeat repeat");
		return mv;
	}

	@GetMapping("hello7/{name}")
	public ModelAndView hello7(@PathVariable String name, ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from path variable");
		return mv;
	}

	@GetMapping("hello8")
	public ModelAndView hello8(@RequestParam("uname") String name, ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from request params");
		return mv;
	}

	@GetMapping("matrix")
	public ModelAndView matrix(@MatrixVariable(name = "uname", defaultValue = "ashok") String name, ModelAndView mv,
			HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from matrix variable");
		return mv;
	}

	@PostMapping("hello9")
	public ResponseEntity<User> hello9() {
		User user = new User();
		user.setUserId(2022);
		user.setUserName("Ashok");
		return ResponseEntity.ok(user);
	}

	@PostMapping("hello10")
	public User hello10() {
		User user = new User();
		user.setUserId(1234);
		user.setUserName("Ramu");
		return user;
	}

	@PostMapping("hello11")
	public User hello11(@RequestBody User user) {
		user.setUserId(1010);
		user.setUserName("---vjvh---");
		return user;
	}

	@PostMapping("sayhai")
	public String hello12(@RequestBody User user) {
		return "Haii... " + user.getUserName() + "\n";
	}
}

class User {
	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
