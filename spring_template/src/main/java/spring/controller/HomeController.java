package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.persistence.dao.HotDao;
import spring.persistence.entity.Shop;
import spring.service.HotService;

@Controller
@RequestMapping("/home")
public class HomeController {
    private HotDao dao;

    @Autowired
    public HomeController(HotDao dao) {
        this.dao = new HotDao();
    }

    @GetMapping("/")
    public String showHome(@RequestParam String keyWord, Model model) {
        HotService service = new HotService(dao);
        List<Shop> shops = service.getShopList(keyWord);
        if(shops==null) {
            return "error";
        }else {
            model.addAttribute("shops", shops);
            return "home";
        }
    }
}
