package spring.persistence.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.persistence.entity.MyException;
import spring.persistence.entity.Shop;

@Component
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
            jsons = jsons.replaceAll("\"access[^,]*,", "");
            jsons = jsons.replaceAll("\"band[^,]*,", "");
            jsons = jsons.replaceAll("\"barrier_free[^,]*,", "");
            jsons = jsons.replaceAll("\"budget\":\\{", "\"budget_");
            jsons = jsons.replaceAll("\"budget_memo[^,]*,", "");
            jsons = jsons.replaceAll("\"capacity[^,]*,", "");
            jsons = jsons.replaceAll("\"card[^,]*,", "");
            jsons = jsons.replaceAll("\"code[^,]*,", "");
            jsons = jsons.replaceAll("\"charter[^,]*,", "");
            jsons = jsons.replaceAll("\"child[^,]*,", "");
            jsons = jsons.replaceAll("\"coupon_urls[^}]*},", "");
            jsons = jsons.replaceAll("\"course[^,]*,", "");
            jsons = jsons.replaceAll("\"english[^,]*,", "");
            jsons = jsons.replaceAll("\"free_[^,]*,", "");
            jsons = jsons.replaceAll("\"horigotatsu[^,]*,", "");
            jsons = jsons.replaceAll("\"id[^,]*,", "");
            jsons = jsons.replaceAll("\"karaoke[^,]*,", "");
            jsons = jsons.replaceAll("\"ktai_coup[^,]*,", "");
            jsons = jsons.replaceAll("\"lat\"[^,]*,", "");
            jsons = jsons.replaceAll("\"lng\"[^,]*,", "");
            jsons = jsons.replaceAll("\"logo_image[^,]*,", "");
            jsons = jsons.replaceAll("\"midnight[^,]*,", "");
            jsons = jsons.replaceAll("\"mobile_access[^,]*,", "");
            jsons = jsons.replaceAll("\"non_smoking[^,]*,", "");
            jsons = jsons.replaceAll("\"other_memo[^,]*,", "");
            jsons = jsons.replaceAll("\"parking[^,]*,", "");
            jsons = jsons.replaceAll("\"party[^,]*,", "");
            jsons = jsons.replaceAll("\"pet\"[^,]*,", "");
            jsons = jsons.replaceAll("\"private_room[^,]*,", "");
            jsons = jsons.replaceAll("\"shop_detail_memo[^,]*,", "");
            jsons = jsons.replaceAll("\"show\"[^,]*,", "");
            jsons = jsons.replaceAll("\"tatami\"[^,]*,", "");
            jsons = jsons.replaceAll("\"tv\"[^,]*,", "");
            jsons = jsons.replaceAll("\"wedding\"[^,]*,", "");

            jsons = jsons.replaceAll("\"average", "average");
            jsons = jsons.replaceAll("円\",\"name[^}]*}", "円\"");

            jsons = jsons.replaceAll("\"genre\":\\{\"catch", "\"genre");
            jsons = jsons.replaceAll("\"name_kana[^,]*,", "");
            jsons = jsons.replaceAll("\",\"name[^}]*}", "\"");

            jsons = jsons.replaceAll("area\":\\{\"name", "area");
            jsons = jsons.replaceAll("},\"lunch", ",\"lunch");
            jsons = jsons.replaceAll("},\"name", ",\"name");
            jsons = jsons.replaceAll("},\"small", ",\"small");
            jsons = jsons.replaceAll("},\"station", ",\"station");
            jsons = jsons.replaceAll("},\"large", ",\"large");

            jsons = jsons.replaceAll("\"photo[^}]*}", "\"photo\"");
            jsons = jsons.replaceAll("\"photo\",[^,]*,", "\"photo\"");
            jsons = jsons.replaceAll("\"photo\"\"m\"", "\"photo\"");
            jsons = jsons.replaceAll(",\"s\"[^}]*}}", "");
            jsons = jsons.replaceAll("\"urls\":\\{\"pc\"", "\"urls\"");
            jsons = jsons.replaceAll("},\"wifi\"[^}]*}", "}");

            jsons = jsons.replaceAll("\"sub_genre[^,]*,", "");

            return jsons;
        }else {
            throw new MyException("検索結果がありません");
        }
    }
}
