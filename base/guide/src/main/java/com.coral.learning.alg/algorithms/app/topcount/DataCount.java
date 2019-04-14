package com.coral.learning.alg.algorithms.app.topcount;

import com.coral.learning.alg.algorithms.sort.HeapSort;

import java.io.*;
import java.util.*;

public class DataCount extends HeapSort<DataNode> {
    public static void main(String[] args) throws IOException {
        //ip统计
        DataCount dataCount = new DataCount();
        //step.1 生成测试数据
        dataCount.create();
        //step.2 读取数据
        List<String> nodes = dataCount.read();
        //step.3 映射数据
        HashMap<String, Integer> maps = dataCount.map(nodes);
        //step.4 数据排序
        DataNode[] dataNodes = dataCount.sort(maps);
        //step.5 打印数据
        System.out.println("all");
        dataCount.print(dataNodes);


        //TOP K
        int k = 5;
        System.out.println("top k" + k);
        //step.6 数据排序
        DataNode[] dataNodesK = dataCount.sort(maps, k);
        //step.7 打印数据
        dataCount.printLast(dataNodesK, k);

    }

    public void create() throws IOException {
        int max = 6;
        File file = new File("ualgorithms/src/test/resources/IpList");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        Random random = new Random();
        for (int i = 0;i < 100000; i++) {
            StringBuilder sb  = new StringBuilder();
            sb.append(random.nextInt(max));
            sb.append(".");
            sb.append(random.nextInt(max));
            sb.append(".");
            sb.append(random.nextInt(max));
            sb.append(".");
            sb.append(random.nextInt(max));
            sb.append("\n");
            fileOutputStream.write(sb.toString().getBytes());
        }
    }

    public List<String> read() throws IOException {
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
    public DataNode[] sort(HashMap<String, Integer> maps, int k) {
        DataNode[] array = new DataNode[maps.size()];
        Iterator iterator = maps.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            DataNode dataNode = new DataNode();
            dataNode.setName((String) entry.getKey());
            dataNode.setCount((Integer) entry.getValue());
            array[i]  = dataNode;
            i++;
        }
        sort(array, k);
        return array;
    }
    public DataNode[] sort(HashMap<String, Integer> maps) {
        return sort(maps, maps.size());
    }

    @Override
    public boolean largeTo(DataNode a, DataNode b) {
        return a.getCount() > b.getCount();
    }

    @Override
    public boolean isLog() {
        return false;
    }
}
