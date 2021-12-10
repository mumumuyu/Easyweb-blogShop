package com.lgd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    int id;
    String name;
    String unit;
    float price;
    int stock;
    String imgUrl;
    String description;
    Date create_time;
    Date update_time;
    int status;
}
