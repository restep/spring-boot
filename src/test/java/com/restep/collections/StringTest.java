package com.restep.collections;

import org.junit.Test;

public class StringTest {
    @Test
    public void test() {
        String str1 = "a";
        String str2 = "b";
        String str3 = str1 + str2;
        //第二种方式可以使用加号 JVM已经做了优化 不会创建多个StringBuilder对象
        //String str = "a" + "b" + "c";
    }
}
