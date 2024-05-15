package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> showAll(@RequestParam(required = false) Integer min,
                                     @RequestParam(required = false) Integer max) {
        if (min == null && max == null) {
            return this.productRepository.findAll();
        }
        var sort = Sort.by(Sort.Order.asc("price"));

        if (min == null) {
            return this.productRepository.findByPriceLessThan(max, sort);
        }

        if (max == null) {
            return this.productRepository.findByPriceGreaterThan(min, sort);
        }
        return this.productRepository.findByPriceBetween(min, max, sort);
    }

//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getProductsGreaterThan(@RequestParam Integer min) {
//        var sort = Sort.by(Sort.Order.asc("price"));
//        var products = this.productRepository.findByPriceGreaterThan(min, sort);
//        return products;
//    }
//
//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getProductsLessThan(@RequestParam Integer max) {
//        var sort = Sort.by(Sort.Order.asc("price"));
//        var products = this.productRepository.findByPriceGreaterThan(max, sort);
//        return products;
//    }
//
//    @GetMapping("")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Product> getProducts() {
//        return this.productRepository.findAll();
//    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
