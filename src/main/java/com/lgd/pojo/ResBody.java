package com.lgd.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResBody<T> {
    public int code;
    //要输出的提示信息
    public String msg;

    //获取的数据条数
    public long count;

    public List<T> data  = new ArrayList<T>();
}