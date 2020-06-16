package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.employeeDao.EmployeeRepo;
import com.example.demo.model.Employee;


@Controller
public class HomeController {
	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("/addEmployee")
	public ModelAndView addEmployee(Employee employee) {
		employee.setLeavesAvailable(10);
		employee.setLeavesTaken(0);
		employee.setLeavesRemaining(10);
		employee.setEmpType("user");
		employee.setLoggedIn(false);
		System.out.println(employee);
		repo.save(employee);
		List<Employee> employees= new ArrayList<Employee>();
		employees = repo.findByEmpType("user");
//		String employeeType = employee.getEmpType();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("employees", employees);
		mv.addObject("employeeType", "admin");
		return mv;
	}
	
	@RequestMapping("/loginPage")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(String empName, int empId) {
		System.out.println(empName + " " + empId);
		Employee employee = repo.getOne(empId);
		String message;
		ModelAndView mv = new ModelAndView();
		if(employee.isLoggedIn()) {
			message = "Already logged in";
//			System.out.println("Employee present");
			String employeeType = employee.getEmpType();
			List<Employee> employees = repo.findByEmpType("user");
			mv.setViewName("home");
			mv.addObject("employees", employees);
			mv.addObject("employee", employee);
			mv.addObject("employeeType", employeeType);
			return mv;
		}else {
			message = "Wrong credentials";
		}
		if(employee != null) {
			System.out.println("Employee present");
			String employeeType = employee.getEmpType();
			List<Employee> employees = repo.findByEmpType("user");
			mv.setViewName("home");
			mv.addObject("employees", employees);
			mv.addObject("employee", employee);
			mv.addObject("employeeType", employeeType);
		}else {
			mv.setViewName("loginPage");
			mv.addObject("message", message);
		}
		return mv;
	}
	
	@RequestMapping("/applyLeave")
	public ModelAndView applyLeave(int empId) {
		Employee employee = repo.getOne(empId);
		ModelAndView mv;
		if(employee.getLeavesAvailable() == employee.getLeavesTaken()) {
			mv = login(employee.getEmpName(), empId);
		}else {
			employee.setLeavesTaken(employee.getLeavesTaken() + 1);
			employee.setLeavesRemaining(employee.getLeavesRemaining() - 1);
			repo.deleteById(empId);
			repo.save(employee);
			mv = login(employee.getEmpName(), empId);
		}
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
		return mv;
	}
	
}
