package com.lysachenko.dao;

import com.lysachenko.model.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getStudentsOrderByAge();

    int getCountOfStudents();

    List<Student> getStudentsByFirstLetter(String letter);

    void deleteStudentsAgeBetween(int startAge, int endAge);
}
