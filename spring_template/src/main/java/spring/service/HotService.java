package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.persistence.dao.HotDao;
import spring.persistence.entity.Shop;

@Component
public class HotService {
    @Autowired
    private HotDao dao;

    public HotService(HotDao dao) {
        this.dao = dao;
    }

    public List<Shop> getShopList(String keyWord){
        keyWord = keyWord.replace("　", " ");
        List<Shop> shops = dao.getDetailStoreList(keyWord);
        return shops;
    }
}

