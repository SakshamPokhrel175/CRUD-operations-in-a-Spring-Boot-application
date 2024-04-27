package com.saksham.Springboottest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

	@Autowired
	StudentService service;

	
	@RequestMapping("/")
	public String callData(Model model) {

		
		  List<Student> list = service.showData(); 
		  for (Student s:list) {
		  System.out.println(s.getId()+s.getName()); 
		  }
		  model.addAttribute("data",list);
		 

		return "index";
	}

	@RequestMapping("/add")
	public String addData(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "addData";

	}

	@RequestMapping(value="/save" , method = RequestMethod.POST)
	public String saveData(@ModelAttribute("student") Student student) {
		service.addNewData(student);
		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editStudent(@PathVariable(name = "id") int id)
	{
		ModelAndView view=new ModelAndView("edit_Student");
		Student student=service.get(id);
		view.addObject("edit");
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name = "id") int id)
	{
		service.delete(id);
		
		return "redirect:/";
	}

}
