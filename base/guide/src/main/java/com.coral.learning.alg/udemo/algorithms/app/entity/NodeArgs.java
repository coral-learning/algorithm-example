package com.coral.learning.alg.udemo.algorithms.app.entity;

public class NodeArgs implements Comparable<NodeArgs>{
    private String name;
    private int value;
    private int number;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    @Override
    public int compareTo(NodeArgs o) {
        return Integer.compare(o.getValue(), this.getValue());
    }
}
