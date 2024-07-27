package Proyecto.Models.normal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Business {
    private String business;
    private String name;
    private String address;
    private String city;
    private String state;
    private String postal_code;
    private double latitude;
    private double longitude;
    private double stars;
    private int review_count;
    private int is_open;
    private Map<String, String> attributes;
    private String categories;
    private Map<String, String> hours;

    // Getters y setters
    @JsonProperty("business")
    public String getBusiness() { return business; }
    public void setBusiness(String business) { this.business = business; }

    @JsonProperty("name")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @JsonProperty("address")
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @JsonProperty("city")
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @JsonProperty("state")
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    @JsonProperty("postal_code")
    public String getPostal_code() { return postal_code; }
    public void setPostal_code(String postal_code) { this.postal_code = postal_code; }

    @JsonProperty("latitude")
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    @JsonProperty("longitude")
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    @JsonProperty("stars")
    public double getStars() { return stars; }
    public void setStars(double stars) { this.stars = stars; }

    @JsonProperty("review_count")
    public int getReview_count() { return review_count; }
    public void setReview_count(int review_count) { this.review_count = review_count; }

    @JsonProperty("is_open")
    public int getIs_open() { return is_open; }
    public void setIs_open(int is_open) { this.is_open = is_open; }

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() { return attributes; }
    public void setAttributes(Map<String, String> attributes) { this.attributes = attributes; }

    @JsonProperty("categories")
    public String getCategories() { return categories; }
    public void setCategories(String categories) { this.categories = categories; }

    @JsonProperty("hours")
    public Map<String, String> getHours() { return hours; }
    public void setHours(Map<String, String> hours) { this.hours = hours; }

    @Override
    public String toString() {
        return "Business{" +
                "business='" + business + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", stars=" + stars +
                ", review_count=" + review_count +
                ", is_open=" + is_open +
                ", attributes=" + attributes +
                ", categories='" + categories + '\'' +
                ", hours=" + hours +
                '}';
    }
}
