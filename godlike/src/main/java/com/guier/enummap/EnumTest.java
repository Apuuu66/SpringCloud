package com.guier.enummap;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenzhen
 * Created by chenzhen on 2018/11/26.
 */
public class EnumTest {

    @Test
    public void testEnum() {
        List enumList = Lists.newArrayList();
        enumList.addAll(Lists.newArrayList(FirstEnum.values()));

    }

    static class TEnumMap {

        private EnumMap<FirstEnum, Map<String, String>> enumMap = new EnumMap<>(FirstEnum.class);

        {
            Map<String, String> map1 = Maps.newHashMap();
            map1.put("服务1", "ServerOne");
            map1.put("服务2", "ServerTwo");
            map1.put("服务3", "ServerThree");
            enumMap.put(FirstEnum.APP_SERVICE, map1);

            Map<String, String> map2 = Maps.newHashMap();
            map2.put("资产1", "AssertOne");
            map2.put("资产2", "AssertTwo");
            map2.put("资产3", "AssertThree");
            enumMap.put(FirstEnum.ASSERT, map2);
        }

    }

    @Test
    public void testTEnumMap() {
        TEnumMap tEnum = new TEnumMap();
        TypeEnumMap typeEnumMap = new TypeEnumMap();
        for (Map.Entry<FirstEnum, Map<String, String>> e : typeEnumMap.typeEnumMap.entrySet()) {
            // for (Map.Entry<FirstEnum, Map<String, String>> e : tEnum.enumMap.entrySet()) {
            System.out.println("******" + e.getKey() + "*****");
            for (Map.Entry<String, String> m : e.getValue().entrySet()) {
                System.out.println(m.getKey() + ":" + m.getValue() + "\t");
            }
            System.out.println();
        }

    }

}


