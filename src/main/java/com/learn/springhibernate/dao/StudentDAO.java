package com.learn.springhibernate.dao;

import java.util.List;

import com.learn.springhibernate.entity.Student;

public interface StudentDAO {

  void save(Student student);

  Student findById(Integer id);

  List<Student> findByName(String name);

  List<Student> findAll();

  void updateStudent(Integer id, String firstName);

  void updateStudent(Integer id, String firstName, String lastName);

  void updateStudent(Integer id, String firstName, String lastName, String email);

  void deleteStudent(Integer id);

}
