package com.lastway.account.test;

import java.sql.SQLException;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractPersistentTest {
	// ======================================
	// =             Attributes             =
	// ======================================

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lastway-test");
	protected EntityManager em;
	protected EntityTransaction tx;

	// ======================================
	// =          Lifecycle Methods         =
	// ======================================

	@Before
	public void initEntityManager() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() throws SQLException {
		if (em != null) em.close();
	}

	protected Long getRandomId() {
		return Math.abs(new Random().nextLong());
	}
}
