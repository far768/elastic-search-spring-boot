package com.example.springbootelasticsearch.controller;

import com.example.springbootelasticsearch.model.Product;
import com.example.springbootelasticsearch.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.IndexedObjectInformation;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/findAll")
    public Iterable<Product> findByProductName() {
        return productService.findAll();
    }

    @GetMapping("/getByName")
    public SearchHits<Product> findByProductName(@RequestParam("name") String name) {
        return productService.findByProductName(name);
    }

    @GetMapping("/getByPrice")
    public SearchHits<Product> findByProductPrice(@RequestParam("price") String price) {
        return productService.findByProductPrice(price);
    }

    @GetMapping("/getByBrand")
    public SearchHits<Product> findProductsByBrand(@RequestParam("brand") String brand) {
        return productService.findProductsByBrand(brand);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam("query") String query) {
        return productService.processSearch(query);
    }

    @GetMapping("/fetchSuggestions")
    public List<String> fetchSuggestions(@RequestParam("query") String query) {
        return productService.fetchSuggestions(query);
    }

    @PostMapping("/createProductIndexBulk")
    public List<IndexedObjectInformation> createProductIndexBulk(@RequestBody List<Product> products) {
        return productService.createProductIndexBulk(products);
    }

    @PostMapping("/createProductIndex")
    public String createProductIndex(@RequestBody Product product) {
        return productService.createProductIndex(product);
    }

    @PostMapping("/createProductsIndex")
    public void createProductIndex(@RequestBody List<Product> products) {
        productService.createProductsIndex(products);
    }

    @PostMapping("/createProduct")
    public void createProduct(@RequestBody Product product) {
        productService.createProduct(product);
    }
}
