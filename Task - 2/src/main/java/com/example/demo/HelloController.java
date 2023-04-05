package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public void sayHai() {
		System.out.println("Hai...We are from CDW");
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello2")
	public String sayHai2() {
		System.out.println("Hellooo222.....");
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello3")
	public ResponseEntity<String> sayHai3() {
		return ResponseEntity.ok("This is a response from ResponseEntity");
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello4")
	public ModelAndView sayHai4() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView");
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello5")
	public ModelAndView sayHai5(ModelAndView mv) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....Injected by View Resolver");
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello6")
	public ModelAndView sayHai6(ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....Injected by View Resolver");
		mv.setViewName("welcome");
		request.setAttribute("hello1", "hello world hello world hello world");

		HttpSession session = request.getSession();
		session.setAttribute("hello2", "session session session");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "repeat")
	public ModelAndView repeat(ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....repeat repeat repeat");
		mv.setViewName("welcome");
		request.setAttribute("hello1", "repeat repeat repeat");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello7/{name}")
	public ModelAndView hello7(@PathVariable String name, ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from path variable");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "hello8")
	public ModelAndView hello8(@RequestParam("uname") String name, ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from request params");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "matrix")
	public ModelAndView matrix(@MatrixVariable(name = "uname", defaultValue = "ashok") String name, ModelAndView mv, HttpServletRequest request) {
		mv.addObject("mykey", "Welcome to CDW, Value from ModelAndView....");
		mv.setViewName("welcome");
		request.setAttribute("hello1", name + " comes from matrix variable");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "hello9")
	public ResponseEntity<User> hello9(){
		User user = new User();
		user.setUid(2022);
		user.setUname("Ashok");
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "hello10")
	public User hello10(){
		User user = new User();
		user.setUid(1234);
		user.setUname("Ramu");
		return user;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "hello11")
	public User hello11(@RequestBody User user){
		user.setUid(1010);
		user.setUname("---vjvh---");
		return user;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "sayhai")
	public String hello12(@RequestBody User user){
		return "Haii... " + user.getUname()+"\n";
	}
}

class User{
	int uid;
	String uname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}