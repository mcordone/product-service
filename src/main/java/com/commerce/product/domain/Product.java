package com.commerce.product.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by jcordones13 on 6/6/17.
 */

@Getter
@Setter
public class Product {
  private Long productId;
  private String name;
  private String description;
  private Double wholesalePrice;
  private Double buyPrice;
  private Double salePrice;
  private int onSale;
  private int unitsInStock;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
}