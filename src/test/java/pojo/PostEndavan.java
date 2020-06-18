package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PostEndavan {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("Favorite Food")
    @Expose
    private String favoriteFood;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostEndavan() {
    }

    /**
     *
     * @param city
     * @param author
     * @param favoriteFood
     * @param company
     * @param id
     * @param title
     */
    public PostEndavan(String title, String author, String company, String city, String favoriteFood, Integer id) {
        super();
        this.title = title;
        this.author = author;
        this.company = company;
        this.city = city;
        this.favoriteFood = favoriteFood;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("title", title).append("author", author).append("company", company).append("city", city).append("favoriteFood", favoriteFood).append("id", id).toString();
    }

}