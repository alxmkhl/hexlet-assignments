package exercise.controller;

import java.util.List;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.handler.GlobalExceptionHandler;
import exercise.mapper.ProductMapper;
import exercise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus (HttpStatus.OK)
    public List<ProductDTO> getProducts(){
        var products = this.productRepository.findAll();
        return products.stream().map(product -> this.productMapper.map(product)).toList();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable Long id) {
        var product = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found."));
        System.out.println(product.getCategory().getName());
        return this.productMapper.map(product);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCreateDTO createProduct(@Valid @RequestBody ProductCreateDTO productCreateDTO) {
        try {
            var product = this.productMapper.map(productCreateDTO);
            this.productRepository.save(product);
        } catch (Exception a) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST);
        }

        return productCreateDTO;
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDTO productUpdateDTO) {
        try {
            var product = this.productRepository.findById(id).get();
            this.productMapper.update(productUpdateDTO, product);
            product.setCategory(this.categoryRepository.findById(productUpdateDTO.getCategoryId().get()).orElseThrow(() -> new ResourceNotFoundException("")));
            this.productRepository.save(product);
            return this.productMapper.map(product);
        } catch (Exception a) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        this.productRepository.deleteById(id);
    }
    // END
}
