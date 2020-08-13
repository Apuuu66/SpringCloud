package com.guier.springboot.design.factory;

import com.google.common.collect.Maps;
import com.guier.springboot.design.handler.Handler;
import org.springframework.util.StringUtils;

import java.util.Map;

public class Factory {
    private static Map<String, Handler> strategyMap = Maps.newHashMap();

    public static Handler getInvokeStrategy(String strategy) {
        Handler handler = strategyMap.get(strategy);
        if (handler == null) {
            return strategyMap.get("defaultHandler");
        }
        return handler;
    }

    public static void register(String strategy, Handler handler) {
        if (StringUtils.isEmpty(strategy) || null == handler) {
            return;
        }
        strategyMap.put(strategy, handler);
    }

}
