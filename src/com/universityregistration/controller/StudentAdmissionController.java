package com.universityregistration.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.universityregistration.model.Shop;
import com.universityregistration.model.Student;
import com.universityregistration.service.StudentService;

@Controller
public class StudentAdmissionController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login() {

		ModelAndView model = new ModelAndView("login");

		return model;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String submitLoginForm(@ModelAttribute("user1") User user1,
			HttpServletRequest request) {

		if (user1.username != null && user1.password != null) {
			if (user1.username.equals("vince")
					&& user1.password.equals("password")) {
				request.getSession().setAttribute("LOGGEDIN_USER", user1);
				return "redirect:/admissionForm.html";
			} else {
				return "redirect:/login.failed";
			}
		} else {
			return "redirect:/login.failed";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {

		request.getSession().setAttribute("LOGGEDIN_USER", null);
		ModelAndView model = new ModelAndView("login");

		return model;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setDisallowedFields(new String[] {"studentMobile"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB",
				new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName",
				new StudentNameEditor());
	}

	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model1 = new ModelAndView("AdmissionForm");

		return model1;
	}

	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage",
				"Gontu College of Engineering, India");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(
			@Valid @ModelAttribute("student1") Student student1,
			BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		
		student1.getStudentDOB();
		
		studentService.insertRow(student1);

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		return model;
	}
	
	@RequestMapping("studentList")
	public ModelAndView showAccounts(){
		List<Student> studentList = studentService.getList();
		System.out.println(studentList);
		return new ModelAndView("studentList","studentList",studentList);
	}
	
	@RequestMapping("delete")  
	 public ModelAndView deleteUser(@RequestParam int id) {  
	  studentService.deleteRow(id);  
	  return new ModelAndView("redirect:studentList");  
	 }  
	  
	 @RequestMapping("edit")  
	 public ModelAndView editUser(@RequestParam int id,  
	   @ModelAttribute Student student) {  
		 Student studentObject = studentService.getRowById(id);  
		 studentObject.getStudentDOB();
	  return new ModelAndView("edit", "studentObject", studentObject);  
	 }  
	  
	 @RequestMapping("update")  
	 public ModelAndView updateUser(@ModelAttribute Student student) {  
		 System.out.println("Update Before service");
		 studentService.updateRow(student);  
		 System.out.println("Update After service");
	  return new ModelAndView("redirect:/studentList");  
	 }  
	 
	 
	 @RequestMapping("showDialog") 
	 public  @ResponseBody Student showDialog(@ModelAttribute Student student) {  
		 String responsCode = student.getStudentName();
		 System.out.println("Name: "+ student.getStudentName());
	  return student;  
	 }  
	 
	 
	
	 
}