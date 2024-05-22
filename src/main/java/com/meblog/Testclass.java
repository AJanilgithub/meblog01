package com.meblog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Testclass {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(10, 20, 23, 14, 16, 65, 67, 86,23,67,14);
        List<Integer> val = data.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(val);
        System.out.println("hello");
    }


}
