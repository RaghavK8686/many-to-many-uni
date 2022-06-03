package com.ty.many_to_many_uni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestGetStudentByCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student=entityManager.find(Student.class,3);
		
		if(student!=null)
		{
			System.out.println("student id is :"+student.getId());
			System.out.println("student name is :"+student.getName());
			System.out.println("student age is :"+student.getAge());
			System.out.println("student course is :"+student.getCourse());
			
			List<Course> course=student.getCourse();
			for(Course e: course)
			{
				System.out.println("********************");
				System.out.println("course id is :"+e.getId());
				System.out.println("course name is :"+e.getName());
				System.out.println("course duration is :"+e.getDuration());
				System.out.println("********************");
			}
		}
		else
		{
			System.out.println("Student or course not present ");
		}
	}

}
