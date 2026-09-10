package com.jpademo.jpa10926.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;

import com.jpademo.jpa10926.beans.Student;
import com.jpademo.jpa10926.entites.*;
@Transactional(value = "transactionManager")
@Repository 
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext 
    private EntityManager entityManager;

    @Override
    public int save(com.jpademo.jpa10926.beans.Student student) {

        // EntityManager entityManager = null;

        StudentEntity studentEntity = new StudentEntity();

        BeanUtils.copyProperties(student, studentEntity);
        int studentid =0;
        try{
            
            entityManager.persist(studentEntity);
           
            studentid = studentEntity.getStuid();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // No need to close the entityManager as it is managed by the container
        }

        return studentid;
    }
    @Override
public Student getStudentById(int studentId) {

    // EntityManager entityManager = null;
    Student student = null;

    try {

        // entityManager = entityManagerFactory.createEntityManager();

        StudentEntity studentEntity =
                entityManager.find(StudentEntity.class, studentId);

        if (studentEntity != null) {

            student = new Student();

            BeanUtils.copyProperties(studentEntity, student);
        }

    } catch (Exception e) {

        e.printStackTrace();

    } finally {

        // if (entityManager != null) {

        //     entityManager.close();
        // }
    }

    return student;
}
    @Override
    public Student updateStudent(Student student) {

        // EntityManager entityManager = null;
        Student updatedStudent = null;

        try {
            // entityManager = entityManagerFactory.createEntityManager();
            // entityManager.getTransaction().begin();

            StudentEntity studentEntity = entityManager.find(StudentEntity.class, student.getStuid());
            if (studentEntity != null) {
                studentEntity.setName(student.getName());
                studentEntity.setMark(student.getMark());
                entityManager.merge(studentEntity);
                updatedStudent = student;
                
            }

            // entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // if (entityManager != null) {
            //     entityManager.close();
            // }
        }

        return updatedStudent;
    }
    @Override
    public void deleteStudent(int studentId) {

        try {
            StudentEntity studentEntity = entityManager.find(StudentEntity.class, studentId);
            if (studentEntity != null) {
                entityManager.remove(studentEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}