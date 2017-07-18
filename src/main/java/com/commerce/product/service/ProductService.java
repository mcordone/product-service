package com.commerce.product.service;

import com.commerce.product.doa.ProductDao;
import com.commerce.product.domain.Product;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jcordones13 on 3/4/17.
 */

@Component
public class ProductService {

  private final ProductDao productDao;

  @Autowired
  public ProductService(ProductDao productDao){
    this.productDao = productDao;
  }

  /**
   * Returns product entity associated with corresponding id
   * @param id
   * @return Product
   */
  public Product getProduct(final Long id){
    return null;
  }

  /**
   *
   * @return product collection
   */
  public Collection<Product> getProducts(){

    return null;
  }

  /**
   *
   * @param product
   * @return Product
   */
  public Product createProduct(final Product product){

    return null;
  }

  /**
   *
   * @param product
   * @return Product
   */
  public Product updateProduct(final Product product){

    return null;
  }

  /**
   * @param productId
   * @return product
   */
  public Product deleteProduct(final Long productId){

    return null;
  }
}
