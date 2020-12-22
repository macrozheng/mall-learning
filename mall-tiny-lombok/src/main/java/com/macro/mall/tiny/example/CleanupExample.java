package com.macro.mall.tiny.example;

import lombok.Cleanup;

import java.io.*;

/**
 * Created by macro on 2020/12/16.
 */
public class CleanupExample {
    public static void main(String[] args) throws IOException {
        String inStr = "Hello World!";
        //使用输入输出流自动关闭，无需编写try catch和调用close()方法
        @Cleanup ByteArrayInputStream in = new ByteArrayInputStream(inStr.getBytes("UTF-8"));
        @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        while (true) {
            int r = in.read(b);
            if (r == -1) break;
            out.write(b, 0, r);
        }
        String outStr = out.toString("UTF-8");
        System.out.println(outStr);
    }
}
