package spring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({
        "address",
        "budget_average",
        "catch",
        "close",
        "genre",
        "large_area",
        "large_service_area",
        "lunch",
        "middle_area",
        "name",
        "open",
        "photo",
        "service_area",
        "small_area",
        "station_name",
        "urls"
})
public class Shop {

    @JsonProperty("address")
    private String address;
    @JsonProperty("budget_average")
    private String budgetAverage;
    @JsonProperty("catch")
    private String _catch;
    @JsonProperty("close")
    private String close;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("large_area")
    private String largeArea;
    @JsonProperty("large_service_area")
    private String largeServiceArea;
    @JsonProperty("lunch")
    private String lunch;
    @JsonProperty("middle_area")
    private String middleArea;
    @JsonProperty("name")
    private String name;
    @JsonProperty("open")
    private String open;
    @JsonProperty("photo")
    private String photo;
    @JsonProperty("service_area")
    private String serviceArea;
    @JsonProperty("small_area")
    private String smallArea;
    @JsonProperty("station_name")
    private String stationName;
    @JsonProperty("urls")
    private String urls;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("budget_average")
    public String getBudgetAverage() {
        return budgetAverage;
    }

    @JsonProperty("budget_average")
    public void setBudgetAverage(String budgetAverage) {
        this.budgetAverage = budgetAverage;
    }

    @JsonProperty("catch")
    public String getCatch() {
        return _catch;
    }

    @JsonProperty("catch")
    public void setCatch(String _catch) {
        this._catch = _catch;
    }

    @JsonProperty("close")
    public String getClose() {
        return close;
    }

    @JsonProperty("close")
    public void setClose(String close) {
        this.close = close;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("large_area")
    public String getLargeArea() {
        return largeArea;
    }

    @JsonProperty("large_area")
    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea;
    }

    @JsonProperty("large_service_area")
    public String getLargeServiceArea() {
        return largeServiceArea;
    }

    @JsonProperty("large_service_area")
    public void setLargeServiceArea(String largeServiceArea) {
        this.largeServiceArea = largeServiceArea;
    }

    @JsonProperty("lunch")
    public String getLunch() {
        return lunch;
    }

    @JsonProperty("lunch")
    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    @JsonProperty("middle_area")
    public String getMiddleArea() {
        return middleArea;
    }

    @JsonProperty("middle_area")
    public void setMiddleArea(String middleArea) {
        this.middleArea = middleArea;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("open")
    public String getOpen() {
        return open;
    }

    @JsonProperty("open")
    public void setOpen(String open) {
        this.open = open;
    }

    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @JsonProperty("service_area")
    public String getServiceArea() {
        return serviceArea;
    }

    @JsonProperty("service_area")
    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    @JsonProperty("small_area")
    public String getSmallArea() {
        return smallArea;
    }

    @JsonProperty("small_area")
    public void setSmallArea(String smallArea) {
        this.smallArea = smallArea;
    }

    @JsonProperty("station_name")
    public String getStationName() {
        return stationName;
    }

    @JsonProperty("station_name")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("urls")
    public String getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(String urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Address = " + this.address + "\nName = " + this.name;
    }
}