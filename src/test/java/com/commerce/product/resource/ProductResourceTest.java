package com.commerce.product.resource;

import com.commerce.product.domain.Product;
import com.commerce.product.mapper.ProductMapper;
import com.commerce.product.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jcordones13 on 6/6/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductResourceTest {

  @Mock
  private ProductMapper productMapper;

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductResource productResource;

  private List<Product> productList;

  @Test
  public void getProduct() throws Exception {

    when(productService.getProduct(anyLong())).thenReturn(createProduct());

    ResponseEntity<Product> responseEntity = productResource.getProduct(anyLong());
    assertThat(responseEntity.getBody().getProductId()).isEqualTo(100L);
    assertThat(responseEntity.getBody().getName()).isEqualTo("Tuna Salad");
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    verify(productService, times(1)).getProduct(anyLong());
  }

  @Test
  public void getProducts() throws Exception {

    when(productService.getProducts()).thenReturn(createProductList());

    ResponseEntity<List<Product>> responseEntity = productResource.getProducts();
    assertThat(responseEntity.getBody().get(0).getProductId()).isEqualTo(100L);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

    verify(productService, times(1)).getProducts();
  }

  private Product createProduct(){
    Product product = new Product();
    product.setProductId(100L);
    product.setName("Tuna Salad");

    return product;
  }

  private List<Product> createProductList(){
    Product product = new Product();
    product.setProductId(100L);
    product.setName("Tuna Salad");

    List<Product> products = new ArrayList<>();
    products.add(product);

    return products;
  }

}