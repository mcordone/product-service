package com.commerce.product.util;

import com.commerce.product.domain.Product;
import com.commerce.product.mapper.ProductMapper;

import java.util.Random;

/**
 * Created by miguelcordones on 6/29/17.
 */
public final class ProductUtil {
    private static final Random random = new Random();

    public static Product createProduct(){
        Product product = new Product();
        product.setName("Product-test-" + random.nextInt());
        product.setDescription("Product test ");
        product.setProductId(random.nextLong());
        product.setBuyPrice(random.nextDouble());

        return product;
    }

    public static Product insertProduct(ProductMapper mapper){
        Product product = createProduct();
        int result = mapper.createProduct(product);
        assert result > 0 : "Not product inserted in DB";

        product = mapper.getProductByName(product.getName());

        return product;
    }
}
