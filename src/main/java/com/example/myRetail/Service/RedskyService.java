package com.example.myRetail.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 * @author Alazar Zewde
 *
 * A Service class that will handle the retrieval of product names from the RedSky API
 */
public class RedskyService {
    private static final String BASE_URL = "https://redsky.target.com/v3/pdp/tcin/";
    private static final String QUERY_PARAMS = "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate";

    /**
     * Get Product info from the Redsky API
     * @param productId
     * @return Product Information JSON from the Redsky API
     */
    public ResponseEntity<String> getProductName(int productId) throws IOException, InterruptedException {
        String url = BASE_URL + String.valueOf(productId) + QUERY_PARAMS;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        return  ResponseEntity.ok(parseName(body));
    }

    /**
     * Parses through the nested json object from the RedSky api and retrieves a product's name
     */
    private String parseName(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map> infoMapJson = mapper.readValue(json, Map.class);
        Map<String, Map> product = infoMapJson.get("product");
        Map<String, Map> itemMap = product.get("item");
        Map<String, String> productDescription = itemMap.get("product_description");
        return productDescription.get("title");
    }

}
