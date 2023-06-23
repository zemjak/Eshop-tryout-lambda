package sk.eworks.eshoptryout.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Objects;
import java.util.Set;

@DynamoDbBean
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingItem {
    private String _id;
    private String guid;
    private float price;
    private int discount;
    private String picture;
    private int availablePieces;
    private float rating;
    private String name;
    private String about;
    private Set<String> tags;

    public ShoppingItem() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @DynamoDbPartitionKey
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAvailablePieces() {
        return availablePieces;
    }

    public void setAvailablePieces(int availablePieces) {
        this.availablePieces = availablePieces;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingItem that)) return false;
        return Float.compare(that.getPrice(), getPrice()) == 0 && getDiscount() == that.getDiscount() && getAvailablePieces() == that.getAvailablePieces() && Float.compare(that.getRating(), getRating()) == 0 && Objects.equals(get_id(), that.get_id()) && Objects.equals(getGuid(), that.getGuid()) && Objects.equals(getPicture(), that.getPicture()) && Objects.equals(getName(), that.getName()) && Objects.equals(getAbout(), that.getAbout()) && Objects.equals(getTags(), that.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get_id(), getGuid(), getPrice(), getDiscount(), getPicture(), getAvailablePieces(), getRating(), getName(), getAbout(), getTags());
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "_id='" + _id + '\'' +
                ", guid='" + guid + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", picture='" + picture + '\'' +
                ", availablePieces=" + availablePieces +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", tags=" + tags +
                '}';
    }
}
