package com.guier.enummap;

import com.google.common.collect.Maps;

import java.util.EnumMap;
import java.util.Map;

public class TypeEnumMap {

    public static EnumMap<FirstEnum, Map<String, String>> typeEnumMap = new EnumMap<>(FirstEnum.class);

    static {
        Map<String, String> map1 = Maps.newHashMap();
        map1.put("tuxedo_app_server", "Tuxedo服务");
        map1.put("microServiceRestfull_app_server", "微服务接口服务");
        map1.put("weblogic_app_server", "WebLogic服务");
        typeEnumMap.put(FirstEnum.APP_SERVICE, map1);

        Map<String, String> map2 = Maps.newHashMap();
        map2.put("Server", "服务器");
        typeEnumMap.put(FirstEnum.ASSERT, map2);


        Map<String, String> map3 = Maps.newHashMap();
        map3.put("JDBC", "JDBC连接配置");
        map3.put("manathon", "marathon_app节点定义");
        map3.put("Oracle_store", "Oracle存储");
        map3.put("Oracle_rac", "Oracle_rac");
        map3.put("WTC", "WTC");
        map3.put("wtc_exports", "wtc_exports");
        map3.put("wtc_imports", "wtc_imports");
        map3.put("wtc_local", "wtc_local");
        map3.put("wtc_remote", "wtc_remote");
        map3.put("Application", "应用服务");
        map3.put("app_cluster", "应用集群");

        map3.put("App_server_cluster_tuxedo","Tuxedo集群");
        map3.put("App_server_cluster_weblogic","WebLogic集群");
        typeEnumMap.put(FirstEnum.CONFIG_INFO,map3);



        Map<String,String> map4 = Maps.newHashMap();
        map4.put("HDFS","HDFS节点");
        map4.put("Tuxedoserver","Tuxedo服务节点");
        map4.put("weblogicconsle","weblogic控制台节点");
        map4.put("weblogic","weblogic节点");
        map4.put("ZooKeeper","Zookeeper节点");
        map4.put("F5Info","F5负载均衡节点");
        map4.put("Hbaseserver","HBase节点");
        map4.put("Kafka","Kafka节点");
        map4.put("marath","marathon_lb负载均衡节点");
        map4.put("Oracledb","Oracle数据库节点");
        map4.put("Mysqlserver","Mysql节点");
        map4.put("redis","Redis节点");
        map4.put("Tomcatserver","Tomcat节点");
        map4.put("Othersoftware","其他软件节点");
        typeEnumMap.put(FirstEnum.INSTANCE_NODE,map4);


    }
}


