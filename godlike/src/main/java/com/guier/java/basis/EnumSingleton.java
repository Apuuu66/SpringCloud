package com.guier.java.basis;

public enum EnumSingleton {
    INSTANCE;
    private DBConnection connection = null;

    EnumSingleton() {
        connection = new DBConnection();
    }

    public DBConnection getConnection() {
        return connection;
    }
}

class DBConnection {
}