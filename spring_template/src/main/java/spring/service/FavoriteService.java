package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.persistence.entity.Shop;
import spring.persistence.mapper.ShopsMapper;

@Component
public class FavoriteService {
    private ShopsMapper mapper;

    @Autowired
    public FavoriteService(ShopsMapper mapper) {
        this.mapper = mapper;
    }

    public List<Shop> getFavoriteList(){
        return mapper.findAll();
    }

    public void setFavorite(Shop shop) {
        System.out.println(shop.getCatch());
        mapper.insertFavorite(shop);
    }
}
