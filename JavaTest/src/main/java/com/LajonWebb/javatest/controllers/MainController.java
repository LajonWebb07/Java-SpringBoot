package com.LajonWebb.javatest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LajonWebb.javatest.models.Show;
import com.LajonWebb.javatest.models.User;
import com.LajonWebb.javatest.repositories.ShowRep;
import com.LajonWebb.javatest.repositories.UserRep;
import com.LajonWebb.javatest.services.ShowService;
import com.LajonWebb.javatest.services.UserService;
import com.LajonWebb.javatest.validator.UserValidator;

@Controller
public class MainController {
	private final UserRep userRep;
	private final UserService userService;
	private final UserValidator userValidator;
	private final ShowRep showRep;
	private final ShowService showServ;

	
	public MainController(
			UserRep userRep,
			UserService userService,
			UserValidator userValidator,
			ShowRep showRep,
			ShowService showService
			) {
		this.userRep = userRep;
		this.userService = userService;
        this.userValidator = userValidator;
        this.showRep = showRep;
        this.showServ = showService;
	}
	
	
	@GetMapping("/")
	public String regAndLogin(Model model) {
		System.out.println("hello");
		model.addAttribute("user_r", new User());
		return "logReg.jsp";
	}
	
	@PostMapping("/registration")
	public String register(@Valid @ModelAttribute("user_r") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
        if(result.hasErrors()) {
            return "logReg.jsp";
        }
        User u = userService.registerUser(user);
        session.setAttribute("userId", u.getId());
        return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email_l") String email, @RequestParam("password_l") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("user_r", new User());
			model.addAttribute("error", "Invalid Credentials. Please try again");
			return "logReg.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/home")
	public String dash(Model model, HttpSession session) {
		List<Show> shows = showRep.findAll();
		model.addAttribute("shows", shows);
		return "dashboard.jsp";
	}
	
	@GetMapping("/create/show")
	public String showCreate(Model model, HttpSession session) {
		User loggedinUser = userService.findUserById((Long) session.getAttribute("userId"));
		List<String> priorities = new ArrayList<String>();
		priorities.add("High");
		priorities.add("Medium");
		priorities.add("Low");
		List<User> users = userRep.findAll();
		model.addAttribute("priorities", priorities);
		model.addAttribute("users", users);
		model.addAttribute("loggedinUser", loggedinUser);
		model.addAttribute("show", new Show());
		return "Create.jsp";
	}
	
	@PostMapping("/create/show")
	public String createTask(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			User loggedinUser = userService.findUserById((Long) session.getAttribute("userId"));
			List<String> priorities = new ArrayList<String>();
			priorities.add("High");
			priorities.add("Medium");
			priorities.add("Low");
			model.addAttribute("priorities", priorities);
			List<User> users = userRep.findAll();
			model.addAttribute("users", users);
			model.addAttribute("loggedinUser", loggedinUser);
			return "create.jsp";
		} else {
			User u = userService.findUserById((Long) session.getAttribute("userId"));
			//show.setUser(u);
			showRep.save(show);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/show/show/{show_id}")
	public String showTask(Model model, HttpSession session, @PathVariable("show_id") Long id) {
		User loggedinUser = userService.findUserById((Long) session.getAttribute("userId"));
		Show show = showServ.findShowById(id);
		model.addAttribute("loggedinUser", loggedinUser);
		model.addAttribute("show", show);
		return "show.jsp";
	}
	
	@GetMapping("/edit/show/{show_id}")
	public String showEdit(Model model, HttpSession session, @PathVariable("show_id") Long id) {
		User loggedinUser = userService.findUserById((Long) session.getAttribute("userId"));
		
		model.addAttribute("loggedinUser", loggedinUser);
		Show show = showServ.findShowById(id);
		model.addAttribute("show", show);
		return "edit.jsp";
	}
	
	@PostMapping("/edit/show/{show_id}")
	public String editTask(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model model, @PathVariable("show_id") Long id) {
		if(result.hasErrors()) {
			User loggedinUser = userService.findUserById((Long) session.getAttribute("userId"));
			
			model.addAttribute("loggedinUser", loggedinUser);
			return "edit.jsp";
		} else {
			show.setId(id);
			showRep.save(show);
			return "redirect:/home";
		}
	}
	
	//@GetMapping("/edit/show/{show_id}/complete")
	//public String completeTask(@PathVariable("show_id") Long id) {
		//Show show = showServ.findShowById(id);
		//show.setCompleted(1);
		//showRep.save(show);
		//return "redirect:/home";
		
	//}
	
	@GetMapping("/delete/show/{show_id}")
	public String deleteShow(@PathVariable("show_id") Long id) {
		showRep.deleteById(id);
		return "redirect:/home";
	}
	
	
	
}
