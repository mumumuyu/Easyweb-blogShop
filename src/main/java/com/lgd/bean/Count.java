package com.lgd.bean;

public class Count {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Count{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
