package com.lgd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private int u_id;
    private int p_id;
    private int amount;
    private float money;
    private int payment_status;
    private int order_status;
    private Date create_time;
    private User user;
    private Product product;
}
