package spring.service;

import java.util.List;

import spring.persistence.dao.HotDao;
import spring.persistence.entity.Shop;

public class HotService {
    private HotDao dao;

    public HotService(HotDao dao) {
        this.dao = dao;
    }

    public List<Shop> getShopList(String keyWord){
        keyWord = keyWord.replace("　", " ");
        List<Shop> shops = dao.getStoreList(keyWord);
        return shops;
    }
}

