package com.example.myRetail.Data.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "price")
public class Price {

    @JsonIgnore
    @Id
    private int productId;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("value")
    private double price;

    public Price(int productId, double price, String currencyCode) {
        this.productId = productId;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
