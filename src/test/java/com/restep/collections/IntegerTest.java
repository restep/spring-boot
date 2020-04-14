package com.restep.collections;

import org.junit.Test;

public class IntegerTest {
    @Test
    public void test() {
        Integer a = 100;
        Integer b = 100;
        Integer c = 150;
        Integer d = 150;

        System.out.println(a == b);
        System.out.println(c == d);

        System.out.println(a.equals(b));
        System.out.println(c.equals(d));
    }
}
