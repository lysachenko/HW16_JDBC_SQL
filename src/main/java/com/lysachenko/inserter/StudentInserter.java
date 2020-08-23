package com.lysachenko.inserter;

import com.lysachenko.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInserter {
    private static final String INSERT_TEST_STUDENTS_IF_NOT_EXISTS =
            "insert into students select * from (\n" +
                    "select 1, 'Roma', 'Lysachenko', 20, 'Odessa' union\n" +
                    "select 2, 'Dima', 'Marchenko', 25, 'Kiev' union\n" +
                    "select 3, 'Oleg', 'Horun', 21, 'Lvov' union\n" +
                    "select 4, 'Maks', 'Kalinichenko', 35, 'Odessa' union\n" +
                    "select 5, 'Masha', 'Borchova', 27, 'Odessa' union\n" +
                    "select 6, 'Rita', 'Beregova', 31, 'Odessa' union\n" +
                    "select 7, 'Artur', 'Som', 20, 'Kiev' union\n" +
                    "select 8, 'Mark', 'Lavrov', 20, 'Dnepr' union\n" +
                    "select 9, 'Sasha', 'Saharov', 25, 'Dnepr' union\n" +
                    "select 10, 'Roma', 'Saharov', 22, 'Lvov'\n" +
                    ") x where not exists(select * from students);";

    private static final String INSERT_TEST_STUDENTS =
            "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (1, 'Roma', 'Lysachenko', 19, 'Odessa'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (2, 'Dima', 'Marchenko', 16, 'Kiev'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (3, 'John', 'Horun', 18, 'Lvov'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (4, 'Maks', 'Kalinichenko', 20, 'Odessa'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (5, 'Masha', 'Borchova', 27, 'Odessa'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (6, 'Janna', 'Beregova', 31, 'Odessa'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (7, 'Artur', 'Som', 47, 'Kiev'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (8, 'Jeck', 'Lavrov', 52, 'Dnepr'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (9, 'Sasha', 'Saharov', 45, 'Dnepr'); " +
                    "insert into students(ID, FIRST_NAME, LAST_NAME, AGE, CITY) values (10, 'Roma', 'Saharov', 22, 'Lvov'); ";

    public void insertTestValues() {
        try (Connection connection = JDBCUtil.getInstance().getConnection();
             Statement statement = connection.createStatement()
        ) {
            //statement.execute(INSERT_TEST_STUDENTS_IF_NOT_EXISTS);
            statement.execute(INSERT_TEST_STUDENTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
