package com.commerce.product.mapper;

import com.commerce.product.config.ProductConfig;
import com.commerce.product.domain.Product;
import com.commerce.product.util.ProductUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.*;

/**
 * Created by jcordones13 on 5/24/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProductConfig.class)
public class ProductMapperTest {

    private Product firstProduct;
    private Product secondProduct;
    private static Double PRODUCT_NEW_PRICE = 4.50;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private ProductMapper productMapper;

  @Before
  public void setUp(){
      //create (insert) new products in DB
      firstProduct = ProductUtil.insertProduct(productMapper);
      secondProduct = ProductUtil.insertProduct(productMapper);
  }

  @After
  public void tearDown(){
      //todo remove product entry form product table
      int result = productMapper.deleteProduct(firstProduct.getProductId());
      assertThat(result).isGreaterThan(0);

      result = productMapper.deleteProduct(secondProduct.getProductId());
      assertThat(result).isGreaterThan(0);
  }

  @Test
  public void getProductId() throws Exception {
    Long productId = firstProduct.getProductId();
    Product product = productMapper.getProductById(productId);
    assertThat(product.getProductId()).isEqualTo(productId);
    assertThat(product.getName()).isEqualToIgnoringCase(firstProduct.getName());
    assertThat(product.getBuyPrice()).isEqualTo(firstProduct.getBuyPrice());
  }

  @Test
  public void getProducts() throws Exception{
      List<Product> products = productMapper.getProducts();
      assertThat(products.size()).isEqualTo(2);
      assertThat(products.get(1).getName()).isEqualToIgnoringCase("cappuccino");
  }

  @Test
  public void updateProduct(){
      //retrieve second product
      Product product = productMapper.getProductById(secondProduct.getProductId());
      Double productOriginalPrice = product.getBuyPrice();

      assertThat(product.getProductId()).isEqualTo(secondProduct.getProductId());

      //update product
      Product updateProduct = ProductUtil.createProduct();
      updateProduct.setProductId(product.getProductId());
      updateProduct.setName(product.getName());
      updateProduct.setDescription(product.getDescription());
      updateProduct.setBuyPrice(PRODUCT_NEW_PRICE);

      int updateResult = productMapper.updateProduct(updateProduct);
      assertThat(updateResult).isGreaterThan(0);

      Product updatedProduct = productMapper.getProductById(product.getProductId());
      assertNotNull(updatedProduct);
      assertThat(updatedProduct.getBuyPrice()).isEqualTo(PRODUCT_NEW_PRICE);
  }

  @Test
  public void deleteProduct(){
      //insert new product, then delete it
      Product productToDelete = ProductUtil.insertProduct(productMapper);
      assertNotNull(productToDelete);

      //delete newly created product
      int result = productMapper.deleteProduct(productToDelete.getProductId());
      assertThat(result).isGreaterThan(0);
  }
}