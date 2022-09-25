package com.hibernate.hbr_nativeSQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// writeToDB(session);

		NativeQuery sqlQuery = session.createSQLQuery("select * from books"); // table name books

		List<Object[]> objList = sqlQuery.getResultList();

		objList.forEach(s -> {
			System.out.println(Arrays.toString(s));
		});

		session.close();
		factory.close();

	}

	private static void writeToDB(Session session) {

		Transaction transaction = session.beginTransaction();

		for (int i = 1; i < 20; i++) {
			session.save(new Book(i * 10, "Book" + i));
		}

		transaction.commit();
	}
}
