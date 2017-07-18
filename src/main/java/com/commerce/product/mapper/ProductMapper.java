package com.commerce.product.mapper;

import com.commerce.product.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jcordones13 on 3/19/17.
 */
@Mapper
public interface ProductMapper {
    /* select single product by id query */
    String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE productId=#{id}";

    //todo add pagination and sorting
    /* select all product query */
    String SELECT_ALL_PRODUCT = "SELECT * FROM product LIMIT 500";

    /* insert product query */
    String INSERT_PRODUCT = "INSERT INTO product (name, description, wholesalePrice, buyPrice, salePrice, onSale, unitsInStock) " +
            "VALUES(#{name}, #{description}, #{wholesalePrice}, #{buyPrice}, #{salePrice}, #{onSale}, #{unitsInStock})";

    String UPDATE_PRODUCT = "UPDATE product SET name=#{name}, description=#{description}, buyPrice=#{buyPrice} WHERE productId=#{productId}";

    /* delete product query */
    String DELETE_PRODUCT = "DELETE FROM product WHERE productId=#{productId}";

    /* select single product by id query */
    String SELECT_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name=#{name}";


    @Select(SELECT_PRODUCT_BY_ID)
    @Results(id = "productResult", value = {
            @Result(column = "productId", property = "productId"),
            @Result(column = "name", property = "name"),
            @Result(column = "wholesalePrice", property = "wholesalePrice"),
            @Result(column = "buyPrice", property = "buyPrice"),
            @Result(column = "salePrice", property = "salePrice"),
            @Result(column = "onSale", property = "onSale"),
            @Result(column = "unitsInStock", property = "unitsInStock")
    })
    Product getProductById(@Param("id") Long productId);

    @Select(SELECT_ALL_PRODUCT)
    @ResultMap("productResult")
    List<Product> getProducts();

    @Insert(INSERT_PRODUCT)
    @Options(useGeneratedKeys = true, keyProperty = "productId")
    public int createProduct(Product product);

    @Update(UPDATE_PRODUCT)
    int updateProduct(Product product);

    @Delete(DELETE_PRODUCT)
    int deleteProduct(@Param("productId") Long productId);

    @Select(SELECT_PRODUCT_BY_NAME)
    @ResultMap("productResult")
    Product getProductByName(@Param("name") String name);
}
