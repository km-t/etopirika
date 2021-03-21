package spring.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "address",
        "name",
        "open",
        "station_name",
})
public class Shop {

    @JsonProperty("address")
    private String address;
    @JsonProperty("name")
    private String name;
    @JsonProperty("open")
    private String open;
    @JsonProperty("station_name")
    private String stationName;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
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


    @JsonProperty("station_name")
    public String getStationName() {
        return stationName;
    }

    @JsonProperty("station_name")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


    @Override
    public String toString() {
        return "Address = " + this.address + "\nName = " + this.name;
    }
}