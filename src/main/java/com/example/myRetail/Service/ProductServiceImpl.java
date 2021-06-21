package com.example.myRetail.Service;

import com.example.myRetail.Data.Models.Price;
import com.example.myRetail.Data.Models.Product;
import com.example.myRetail.Data.Repositories.PriceRepository;
import com.example.myRetail.Data.Repositories.ProductRepository;
import com.example.myRetail.Exceptions.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private RedskyService redskyService;

    @Override
    public Product getProduct(int productId) throws ProductNotFoundException, IOException, InterruptedException {
        Optional<Price> priceOptional = priceRepository.findById(productId);
        String title = redskyService.getProductName(productId).getBody();

        if(priceOptional.isPresent()) {
            return new Product(productId, title, priceOptional.get());
        }

        throw new ProductNotFoundException();
    }

    @Override
    public void updateProduct(int productId, Price price) throws InterruptedException, IOException, ProductNotFoundException {
        Product product = getProduct(productId);
        priceRepository.save(price);
        productRepository.save(product);
    }
}
