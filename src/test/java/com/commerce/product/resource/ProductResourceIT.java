package com.commerce.product.resource;

import com.commerce.product.application.TestApplication;
import com.commerce.product.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
public class ProductResourceIT {
    Product product;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateProduct(){

    }

    @Test
    public void testGetProductByIdResource(){
        ResponseEntity<Product> response = restTemplate.getForEntity("/products/3", Product.class);

        Product product = response.getBody();
        assertThat(product).isNull();
        //assertThat(product.getName()).isEqualToIgnoringCase("Product-test--159281830");
    }

    @Test
    public void testGetProducts(){

    }

    @Test
    public void testUpdateProduct(){

    }

    @Test
    public void testDeleteProduct(){

    }
}
