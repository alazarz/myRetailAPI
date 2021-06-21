package com.example.myRetail.Controllers;

import com.example.myRetail.Data.Models.Price;
import com.example.myRetail.Data.Models.Product;
import com.example.myRetail.Exceptions.ProductNotFoundException;
import com.example.myRetail.Service.ProductService;
import com.example.myRetail.Service.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Rest Controller class that handles the two REST endpoints for getting and updating Products
 * @author Alazar Zewde
 */
@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path ="/products/{id}", produces = "application/json")
    public ResponseEntity<Product> getProduct(@PathVariable int id) throws ProductNotFoundException {
        Product product = null;
        try
        {
            product = productService.getProduct(id);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @ResponseStatus
    @PutMapping(path = "/products/{id}")
    public ResponseEntity<ServiceResponse> updateProduct(@PathVariable int id, @RequestBody Price price) throws ProductNotFoundException {

        ServiceResponse serviceResponse = new ServiceResponse();

        try {
            productService.updateProduct(id, price);
        } catch (InterruptedException e) {
            e.printStackTrace();
            serviceResponse.setStatusCode(HttpStatus.CONFLICT.value());
            serviceResponse.setMessage(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            serviceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            serviceResponse.setMessage(e.getMessage());
        }

        return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.OK);
    }


}
