package com.coral.learning.alg.algorithms.app.topcount;

import com.udemo.algorithms.app.entity.NodeArgs;

public class DataNode  implements Comparable<NodeArgs>{
    private int count;
    private String name;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(NodeArgs o) {
            return Integer.compare(o.getValue(), this.getCount());
    }

    @Override
    public String toString() {
        return count + ":" + name;
    }
}
