package spring.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import spring.persistence.entity.Shop;

@Mapper
public interface ShopsMapper {
    @Select("SELECT * FROM shops")
    List<Shop> findAll();

    @Insert("INSERT INTO"
            + " SHOPS (urls,name,budget_average,catch,close,genre,large_area,large_service_area,lunch,middle_area,open,service_area,small_area,station_name,photo)"
            + " VALUES ("
            + " #{urls}, #{name}, #{budgetAverage}, #{catch}, #{close}, #{genre}, #{largeArea}, #{largeServiceArea}, #{lunch}, #{middleArea}, #{open}, #{serviceArea}, #{smallArea}, #{stationName}, #{photo} )")
    void insertFavorite(Shop shop);
}
