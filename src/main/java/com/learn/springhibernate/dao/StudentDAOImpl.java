package com.learn.springhibernate.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learn.springhibernate.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void save(Student student) {
    entityManager.persist(student);
  }

  @Override
  public Student findById(Integer id) {

    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findByName(String name) {
    TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE firstName=:data", Student.class);
    query.setParameter("data", name);
    return query.getResultList();
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> query = entityManager.createQuery("SELECT s.email FROM Student s", Student.class);
    return query.getResultList();
  }

  @Override
  @Transactional
  public void updateStudent(Integer id, String firstName) {
    Student student = entityManager.find(Student.class, id);

    if (student == null) {
      throw new IllegalArgumentException("Student of id: " + id + " not found");
    }

    student.setFirstName(firstName);

    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void updateStudent(Integer id, String firstName, String lastName) {
    Student student = entityManager.find(Student.class, id);
    System.out.println("63");
    System.out.println(student);

    if (student == null) {
      throw new IllegalArgumentException("Student of id: " + id + " not found");
    }

    student.setFirstName(firstName);
    student.setLastName(lastName);

    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void updateStudent(Integer id, String firstName, String lastName, String email) {
    Student student = entityManager.find(Student.class, id);

    if (student == null) {
      throw new IllegalArgumentException("Student of id: " + id + " not found");
    }

    student.setFirstName(firstName);
    student.setLastName(lastName);
    student.setEmail(email);

    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void deleteStudent(Integer id) {
    Student student = entityManager.find(Student.class, id);

    if (student == null) {
      throw new IllegalArgumentException("Student of id: " + id + " not found");
    }

    entityManager.remove(student);
  }

}
