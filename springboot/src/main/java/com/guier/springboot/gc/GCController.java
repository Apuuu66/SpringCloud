package com.guier.springboot.gc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Def: -XX:+UseSerialGC -verbose:gc -XX:+PrintGCDetails -Xms200M -Xmx200M -Xmn100M
 *
 * 实验1：
 * -Xms100M
 * -Xmx100M
 * -Xmn70M
 * -XX:PretenureSizeThreshold=5M
 * -XX:+UseParallelGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCDateStamps
 * -XX:+PrintGCCause
 * -Xloggc:gc-old.log
 * -verbose:gc
 *
 * 实验2：
 *
 *
 */
@RestController
public class GCController {

    static List<Object> list = new ArrayList<>();

    @GetMapping("/addlist")
    public void lust(@RequestParam("value") Integer value) throws InterruptedException {
        byte[] bytes = new byte[value * 1024 * 1024];
        list.add(bytes);
    }

    @GetMapping("/clearlist")
    public void clearlist() throws InterruptedException {
        list.clear();
    }
}
