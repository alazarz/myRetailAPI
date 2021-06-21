package com.example.myRetail.Service;

import com.example.myRetail.Data.Models.Price;
import com.example.myRetail.Data.Models.Product;
import com.example.myRetail.Exceptions.ProductNotFoundException;

import java.io.IOException;

public interface ProductService {
    Product getProduct(int productId) throws ProductNotFoundException, IOException, InterruptedException;
    void updateProduct(int productId, Price price) throws InterruptedException, IOException, ProductNotFoundException;
}
