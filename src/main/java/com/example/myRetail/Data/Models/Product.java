package com.example.myRetail.Data.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="products")
public class Product {

    @Id
    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("current_price")
    private Price current_price;

    public Product(long id, String name, Price current_price) {
        this.id = id;
        this.name = name;
        this.current_price = current_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Price price) {
        this.current_price = price;
    }
}

