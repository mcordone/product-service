package com.commerce.product.doa;

import com.commerce.product.config.ProductConfig;
import com.commerce.product.domain.Product;
import com.commerce.product.mapper.ProductMapper;
import com.commerce.product.util.ProductUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by miguelcordones on 6/29/17.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ProductConfig.class)
public class ProductDaoTest {

    @Mock
    private ProductMapper productMapper;
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        productDao = new ProductDao(productMapper);
    }

    @Test
    public void getProductById() throws Exception {
        Product product = ProductUtil.createProduct();
        Long id = product.getProductId();

        when(productMapper.getProductById(id)).thenReturn(product);

        Product result = productDao.getProductById(id);
        assertThat(result.getProductId()).isEqualTo(id);

        verify(productMapper, times(1)).getProductById(id);
    }

}