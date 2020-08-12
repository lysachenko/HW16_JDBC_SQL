package com.lysachenko;

import com.lysachenko.creator.StudentTableCreator;
import com.lysachenko.dao.StudentDao;
import com.lysachenko.dao.impl.StudentDaoImpl;
import com.lysachenko.inserter.StudentInserter;

public class Executor {

    public void run() {
        new StudentTableCreator().create();
        new StudentInserter().insertTestValues();

        StudentDao studentDao = new StudentDaoImpl();
        System.out.println("List of students ordered by age:");
        studentDao.getStudentsOrderByAge().forEach(System.out::println);

        System.out.println("\nCount of students: " + studentDao.getCountOfStudents());

        System.out.println("\nStudents with firstname letter like R:");
        studentDao.getStudentsByFirstLetter("R").forEach(System.out::println);

        studentDao.deleteStudentsAgeBetween(21, 30);
        System.out.println("\nStudent list after deleting:");
        studentDao.getStudentsOrderByAge().forEach(System.out::println);
        System.out.println("\nCount of students after deleting: " + studentDao.getCountOfStudents());
    }
}
