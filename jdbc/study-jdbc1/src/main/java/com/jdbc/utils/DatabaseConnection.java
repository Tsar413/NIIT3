package com.jdbc.utils;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {
    private String driver = "com.mysql.cj.jdbc.Driver";//mysql驱动
    private String url ="jdbc:mysql://127.0.0.1:3306/niit3_teaching?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=GMT%2B8";//连接地址
    private String user ="";//用户
    private String password ="";//密码

    private MysqlDataSource dataSource;

    public DatabaseConnection(){
        this.dataSource = new MysqlDataSource();
        this.dataSource.setUrl(this.url);
        this.dataSource.setUser(this.user);
        this.dataSource.setPassword(this.password);
    }

    public MysqlDataSource getDataSource(){
        return this.dataSource;
    }
}
