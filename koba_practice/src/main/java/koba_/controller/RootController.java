package koba_.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import koba_.persistence.entity.Employee;
import koba_.persistence.mapper.EmployeeMapper;

@Controller
public class RootController {
	private EmployeeMapper mapper;

	@Autowired
	public RootController(EmployeeMapper mapper) {
		this.mapper = mapper;
	}
	@GetMapping("/")
	public String root(Model model) {
		List<Employee> emps = mapper.findAll();
		model.addAttribute("emps",emps);
		return "login";
	}
}
