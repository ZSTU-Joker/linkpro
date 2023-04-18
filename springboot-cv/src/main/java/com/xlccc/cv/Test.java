package com.xlccc.cv;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: linkpro
 * @description:
 * @author: Mr.Wang
 * @create: 2023-04-17 17:41
 **/
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date d = new Date();
        d.getTime();
        String date = sdf.format(d);
        System.out.println(date);
        String substring = date.substring(date.length() - 2);
        System.out.println(substring);
    }
}
