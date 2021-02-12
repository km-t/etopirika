package spring.persistence.entity;

public class Shop {
    private String address;
    private String genre;
    private String name;
    private String name_kana;
    private String urls;

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName_kana() {
        return name_kana;
    }
    public void setName_kana(String name_kana) {
        this.name_kana = name_kana;
    }
    public String getUrls() {
        return urls;
    }
    public void setUrls(String urls) {
        this.urls = urls;
    }


}
