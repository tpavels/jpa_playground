package com.tpavels.hibernate.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class DbNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    public static final String DB_TABLE_PREFIX = "TP_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier(DB_TABLE_PREFIX + name.getText(), name.isQuoted());
    }
}
