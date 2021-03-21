package spring.persistence.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.persistence.entity.MyException;
import spring.persistence.entity.Shop;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotDao {
    private final String APIKEY = "baf72189395489c3";

    public HotDao() {
    }

    public List<Shop> getDetailStoreList(String keyWord) throws JsonMappingException, JsonProcessingException, MyException {
        String baseUrl = "http://webservice.recruit.co.jp/hotpepper/gourmet/v1/?key=" + APIKEY
                + "&count=30&format=json";
        keyWord = "&keyword=" + keyWord;
        String url = baseUrl + keyWord;
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);
        return getDetailShopFromJson(json);
    }

    private List<Shop> getDetailShopFromJson(String json) throws JsonMappingException, JsonProcessingException, MyException {
        json = getDetailJsonFromJsonForAddressGenreName(json);
        Shop[] shops;
        ObjectMapper mapper = new ObjectMapper();
        shops = mapper.readValue(json, Shop[].class);
        return Arrays.asList(shops);
    }

    private String getDetailJsonFromJsonForAddressGenreName(String oldJson) throws MyException {
        if (oldJson.indexOf("\"error\":[") == -1 && oldJson.indexOf("results_returned\":\"0\"") == -1) {
            int s = oldJson.indexOf("shop\":[{") + 7;
            int e = oldJson.indexOf("}]}}") + 1;
            String jsons = "[" + oldJson.substring(s, e) + "]";
            System.out.println(jsons);
            return jsons;
        }else {
            throw new MyException("検索結果がありません");
        }
    }
}
