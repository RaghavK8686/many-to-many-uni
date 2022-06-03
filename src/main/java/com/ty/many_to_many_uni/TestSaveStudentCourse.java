package com.ty.many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = new Student();
		student1.setName("Anil");
		student1.setAge(25);

		Student student2 = new Student();
		student2.setName("Deep");
		student2.setAge(24);

		Course course1 = new Course();
		course1.setName("Java");
		course1.setDuration("4 years");

		Course course2 = new Course();
		course2.setName("python");
		course2.setDuration("2 years");

		Course course3 = new Course();
		course3.setName("js");
		course3.setDuration("3 years");

		List<Course> list = new ArrayList<Course>();
		list.add(course1);
		list.add(course2);
		list.add(course3);

		student1.setCourse(list);
		student2.setCourse(list);

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();

	}

}
