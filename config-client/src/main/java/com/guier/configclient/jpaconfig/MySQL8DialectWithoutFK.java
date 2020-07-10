package com.guier.configclient.jpaconfig;

import org.hibernate.dialect.MySQL8Dialect;

public class MySQL8DialectWithoutFK extends MySQL8Dialect {
    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        // PostgreSQL9Dialect
        // return " alter "+ foreignKey[0] +" set default null " ;
        // Oracle10gDialect
        // return " modify "+ foreignKey[0] +" default null " ;
        return " alter " + foreignKey[0] + " set default null ";

    }
}
