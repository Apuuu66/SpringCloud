package com.guier.enummap;
public enum FirstEnum {

    /**
     * 首层展示支持,V3版本
     */
    APP_SERVICE(1,"服务","app_server"),
    ASSERT(2,"资产","Asset"),
    INSTANCE_NODE(3,"节点","Instancenode"),
    //CLUSTER(4,"集群","app_server_cluster"),
    CONFIG_INFO(5,"配置","Configinfo");
    int code;
    String description;
    String identification;

    FirstEnum(int code, String description, String identification) {
        this.code = code;
        this.description = description;
        this.identification = identification;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}


