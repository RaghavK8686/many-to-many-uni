package com.ty.many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCabPerson {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("raghav");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Person person1 = new Person();
		person1.setName("anil");
		person1.setEmail("anil@gmail.com");
		person1.setAge(24);

		Person person2 = new Person();
		person2.setName("Arundhati");
		person2.setEmail("aru@gmail.com");
		person2.setAge(19);

		Cab cab1 = new Cab();
		cab1.setDriverName("Sharuk");
		cab1.setCost(100.00);

		Cab cab2 = new Cab();
		cab2.setDriverName("SanjayDutt");
		cab2.setCost(500.00);

		List<Person> person = new ArrayList<Person>();
		person.add(person1);
		person.add(person2);

		cab1.setPerson(person);
		cab2.setPerson(person);

		entityTransaction.begin();
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityTransaction.commit();

	}
}
