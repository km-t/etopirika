package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.persistence.entity.Shop;
import spring.service.FavoriteService;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    private FavoriteService service;

    @Autowired
    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showFavorite(Model model) {
        List<Shop> shops = service.getFavoriteList();
        model.addAttribute("shops", shops);
        return "favorite";
    }

    @PostMapping("/fav")
    public String setFavorite(@ModelAttribute Shop favShop) {
        service.setFavorite(favShop);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteFavoriteShop(@RequestParam String address) {
        System.out.println("address======"+address);
        return "redirect:/";
    }
}
