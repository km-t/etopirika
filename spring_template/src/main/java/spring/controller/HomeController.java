package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/")
    public String showHome(@RequestParam String keyWord, Model model) throws NullPointerException, IndexOutOfBoundsException {
            List<Shop> shops = service.getShopList(keyWord);
            int i=1;
            if(i==1) {
                if(Math.random()>0.5)throw new NullPointerException();
                else throw new IndexOutOfBoundsException();
            }
            if(shops==null) {
                return "error";
            }else {
                model.addAttribute("shops", shops);
                return "home";
            }



    }
}
