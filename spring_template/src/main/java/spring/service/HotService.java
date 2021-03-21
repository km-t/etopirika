package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import spring.persistence.dao.HotDao;
import spring.persistence.entity.MyException;
import spring.persistence.entity.Shop;

@Component
public class HotService {
    @Autowired
    private HotDao dao;

    public HotService(HotDao dao) {
        this.dao = dao;
    }

    public List<Shop> getShopList(String keyWord) throws JsonMappingException, JsonProcessingException, MyException{
        keyWord = keyWord.replace("　", " ");
        List<Shop> shops = dao.getDetailStoreList(keyWord);
        return shops;
    }
}

