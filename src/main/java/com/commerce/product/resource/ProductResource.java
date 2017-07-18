package com.commerce.product.resource;

import com.commerce.product.domain.Product;
import com.commerce.product.mapper.ProductMapper;
import com.commerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

/**
 * Created by jcordones13 on 3/4/17.
 */
@Scope("request")
@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity getProducts(){
      Collection<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

      return ResponseEntity.ok(product);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){

      return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){

      return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
