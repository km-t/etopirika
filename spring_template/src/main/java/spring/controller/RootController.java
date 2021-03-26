package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.persistence.entity.PersonForm;

@Controller
public class RootController {
	@GetMapping("/")
	public String root(Model model) {
		PersonForm personForm = new PersonForm();
		model.addAttribute("personForm",personForm);
		return "login";
	}
}
