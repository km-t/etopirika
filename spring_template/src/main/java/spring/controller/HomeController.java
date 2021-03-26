package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import spring.persistence.entity.MyException;
import spring.persistence.entity.PersonForm;
import spring.persistence.entity.Shop;
import spring.service.HotService;

@Controller
@RequestMapping("/home")
public class HomeController {
	private HotService service;

	@Autowired
	public HomeController(HotService service) {
		this.service = service;
	}

	@GetMapping("/test")
	public String root(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "login";
	}

	@GetMapping(value="/")
	public String showHome(String keyWord,Model model, @Validated PersonForm personForm, BindingResult result)
			throws JsonMappingException, JsonProcessingException, MyException {
		if (result.hasErrors()) {
			return "login";
		}
		List<Shop> shops = service.getShopList(keyWord);
		model.addAttribute("shops", shops);
		return "home";
	}
}
