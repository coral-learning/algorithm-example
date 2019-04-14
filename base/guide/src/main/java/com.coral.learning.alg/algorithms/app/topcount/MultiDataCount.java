package com.coral.learning.alg.algorithms.app.topcount;

import com.coral.learning.alg.algorithms.sort.HeapSort;

import java.io.*;
import java.util.*;

public class MultiDataCount extends DataCount{
    private static int multi = 10;
    private static String basePath = "ualgorithms/src/test/resources/IpSp/";
    public static void main(String[] args) throws IOException {
        //ip统计
        MultiDataCount dataCount = new MultiDataCount();
        //step.1 生成测试数据
        dataCount.create();
        //step.2 拆分数据
        List<String> nodes = dataCount.read();
        //step 3 子文件排序
        //TOP K
        int k = 5;
        for (int i = 0; i < multi; i++) {
            //step.3.1 映射数据
            HashMap<String, Integer> maps = dataCount.map(nodes);

            //step.3.2 数据排序
            DataNode[] dataNodesK = dataCount.sort(maps, k);
        }

        //step.4 映射数据
        HashMap<String, Integer> maps = dataCount.map(nodes);

        //step.5 数据排序
        DataNode[] dataNodesK = dataCount.sort(maps, k);

    }

    public List<String> readAndMap() throws IOException {
        File file = new File("ualgorithms/src/test/resources/IpList");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        if (!file.exists()) {
            return null;
        }
        List<String> node = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            node.add(line);
            line = reader.readLine();
        }
        return node;
    }


    /**
     * map
     *
     * @param node
     * @return
     */
    public HashMap<String, Integer> map(List<String> node) {
        HashMap<String, Integer> dataMap = new HashMap<>();
        for (String item : node) {
            Integer integer = dataMap.get(item);
            if (integer == null) {
                integer = new Integer(0);
            }
            integer++;
            dataMap.put(item, integer);
        }
        return dataMap;
    }

    @Override
    public boolean isLog() {
        return false;
    }
}
