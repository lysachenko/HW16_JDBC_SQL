package com.lysachenko.creator;

import com.lysachenko.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTableCreator {

    private static final String DROP_TABLE
            = "drop table if exists STUDENTS";
    private static final String CREATE_TABLE_STUDENTS =
            "create table if not exists students ("
                    + "id integer primary key auto_increment,"
                    + " first_name varchar(255),"
                    + " last_name varchar(255),"
                    + " age integer,"
                    + " city varchar(255));";

    public void create() {
        try (Connection connection = JDBCUtil.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.execute(DROP_TABLE);
            statement.execute(CREATE_TABLE_STUDENTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
