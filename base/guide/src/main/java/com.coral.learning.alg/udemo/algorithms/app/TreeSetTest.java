package com.coral.learning.alg.udemo.algorithms.app;
import com.coral.learning.alg.udemo.algorithms.app.entity.NodeArgs;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 特点
 TreeSet是用来排序的, 可以指定一个顺序, 对象存入之后会按照指定的顺序排列
 使用方式
 a.自然顺序(Comparable)
 TreeSet类的add()方法中会把存入的对象提升为Comparable类型
 调用对象的compareTo()方法和集合中的对象比较
 根据compareTo()方法返回的结果进行存储
 b.比较器顺序(Comparator)
 创建TreeSet的时候可以制定 一个Comparator
 如果传入了Comparator的子类对象, 那么TreeSet就会按照比较器中的顺序排序
 add()方法内部会自动调用Comparator接口中compare()方法排序
 调用的对象是compare方法的第一个参数,集合中的对象是compare方法的第二个参数
 c.两种方式的区别
 TreeSet构造函数什么都不传, 默认按照类中Comparable的顺序(没有就报错ClassCastException)
 TreeSet如果传入Comparator, 就优先按照Compara

 类似于HashMap和HashSet之间的关系，HashSet底层依赖于HashMap实现，TreeSet底层则采用一个NavigableMap来保存TreeSet集合的元素。
 但实际上，由于NavigableMap只是一个接口，因此底层依然是使用TreeMap来包含Set集合中的所有元素。
 TreeSet的①号、②号构造器都是新建一个TreeMap作为实际存储Set元素的容器，而另外2个构造器则分别依赖于①号和②号构造器。由此可见，TreeSet底层实际使用的存储容器就是TreeMap。
 与HashSet完全类似的是，TreeSet里绝大部分方法都是直接调用TreeMap的方法来实现的。
 *
 *
 */

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<NodeArgs> treeSet = new TreeSet<>();
        for (int i = 10 ; i > 0; i--){
            NodeArgs nodeArgs = new NodeArgs();
            nodeArgs.setName("nodeargs" + i);
            nodeArgs.setNumber(i);
            nodeArgs.setValue(i);
            treeSet.add(nodeArgs);
        }
        for(Iterator iter = treeSet.iterator(); iter.hasNext(); ) {
            NodeArgs nodeArgs = (NodeArgs) iter.next();
            System.out.println(nodeArgs.getName());
        }

    }
}
