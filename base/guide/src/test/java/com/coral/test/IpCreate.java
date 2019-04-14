package com.coral.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class IpCreate {
    static int max = 3;
    public static void main(String[] args) throws IOException {
        File file = new File("base/guide/src/test/resources/IpList");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        Random random = new Random();
        for (int i = 0;i < 1000; i++) {
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
}
