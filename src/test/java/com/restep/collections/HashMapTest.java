package com.restep.collections;

import com.google.common.collect.Maps;
import org.junit.Test;
import java.util.Map;

public class HashMapTest {
    @Test
    public void newHashMap() {
        Map<String, String> map = Maps.newHashMapWithExpectedSize(2);
        map.put("a", "aaa");
        map.put("b", "bbb");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
