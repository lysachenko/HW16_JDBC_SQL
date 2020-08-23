package com.lysachenko.dao.impl;

import com.lysachenko.dao.StudentDao;
import com.lysachenko.model.Student;
import com.lysachenko.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private static final String GET_ALL_STUDENTS_ORDER_BY_AGE = "select * from students order by age";
    private static final String COUNT_OF_STUDENTS = "select count(*) from students";
    private static final String GET_STUDENTS_BY_FIRST_LETTER = "select * from students where FIRST_NAME like ? || '%';";
    private static final String DELETE_STUDENTS_WHERE_AGE_BETWEEN = "delete from students where AGE >= ? and AGE <= ?;";

    @Override
    public List<Student> getStudentsOrderByAge() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = JDBCUtil.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_ORDER_BY_AGE)
        ) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setAge(rs.getInt("age"));
                student.setCity(rs.getString("city"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int getCountOfStudents() {
        int count = -1;
        try (Connection connection = JDBCUtil.getInstance().getConnection();
             Statement preparedStatement = connection.createStatement()
        ) {
            ResultSet rs = preparedStatement.executeQuery(COUNT_OF_STUDENTS);

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Student> getStudentsByFirstLetter(String letter) {
        List<Student> students = new ArrayList<>();
        try (Connection connection = JDBCUtil.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENTS_BY_FIRST_LETTER)
        ) {
            preparedStatement.setString(1, letter);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));
                student.setAge(rs.getInt("age"));
                student.setCity(rs.getString("city"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void deleteStudentsAgeBetween(int startAge, int endAge) {
        try (Connection connection = JDBCUtil.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_WHERE_AGE_BETWEEN)
        ) {
            preparedStatement.setInt(1, startAge);
            preparedStatement.setInt(2, endAge);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
