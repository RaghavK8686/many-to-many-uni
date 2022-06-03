package com.ty.many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourseforSecondStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student3 = new Student();
		student3.setName("Palak");
		student3.setAge(45);

		Course course1 = entityManager.find(Course.class, 2);
		Course course2 = entityManager.find(Course.class, 3);

		List<Course> course = new ArrayList<Course>();
		course.add(course1);
		course.add(course2);

		student3.setCourse(course);

		entityTransaction.begin();
		entityManager.persist(student3);
		entityTransaction.commit();
	}

}
