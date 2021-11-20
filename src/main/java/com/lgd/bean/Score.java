package com.lgd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    int id;
    int u_id;
    int b_id;
    Date create_time;
    int score;
    Boke boke;
    User user;
}
