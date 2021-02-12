package spring.persistence.dao;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import spring.persistence.entity.Shop;

@Component
public class HotDao {

    public HotDao() {
    }

    public List<Shop> getStoreList(String keyWord){
        String key = "baf72189395489c3";
        String url = "http://webservice.recruit.co.jp/hotpepper/shop/v1/?key="+key+"&keyword="+keyWord+"&count=30&format=json";
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(url, String.class);
        return getShopFromJson(json);
    }

    private List<Shop> getShopFromJson(String json){
        String newJson = getJsonFromJsonForAddressGenreName(json);
        if(newJson!=null) {
            Shop[] shops;
            try {
                ObjectMapper mapper = new ObjectMapper();
                shops = mapper.readValue(newJson, Shop[].class);
                return Arrays.asList(shops);
            }catch(IOException e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    private String getJsonFromJsonForAddressGenreName(String oldJson) {
        if(oldJson.indexOf("\"error\":[")==-1 && oldJson.indexOf("results_returned\":\"0\"")==-1) {
            int s = oldJson.indexOf("shop\":[{") + 7;
            int e = oldJson.indexOf("}}]}}") + 2;
            String jsons = "["+oldJson.substring(s, e)+"]";
            jsons = jsons.replaceAll("\"desc\":\"[0-9]\",", "");
            jsons = jsons.replaceAll(":\\{\"name\"", "");
            jsons = jsons.replaceAll("},\"id\":\"[0-9a-zA-Z]{10}\"", "");
            jsons = jsons.replace(":{\"pc\"", "");
            jsons = jsons.replace("}}", "}");
            return jsons;
        }else {
            return null;
        }
    }
}
