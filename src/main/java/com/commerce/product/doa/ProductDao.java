package com.commerce.product.doa;

import com.commerce.product.domain.Product;
import com.commerce.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by miguelcordones on 6/27/17.
 */
@Repository
public class ProductDao
{
    private final ProductMapper productMapper;

    @Autowired
    public ProductDao(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    public Product getProductById(Long id){
        Product product = productMapper.getProductById(id);
        return product;
    }

    //public getProductById(Long id){}
}
