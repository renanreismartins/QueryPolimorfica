package br.com.renan.integracao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.renan.domain.Notificador;
import br.com.renan.domain.Notificavel;
import br.com.renan.domain.Pessoa;
import br.com.renan.domain.Sistema;
import br.com.renan.infra.HibernateUtil;
import br.com.renan.infra.NotificadorDAOHibernate;

public class QueryPolimorficaTest {
	private Session session;

	private Notificador notificador;

	@Test
	public void deveRetornarDoisVeiculos() {
		List<Notificavel> notificaveis = notificador.lista();
		assertEquals(2, notificaveis.size());
	}

	private void load() {
		Notificavel pessoa = new Pessoa("Renan");
		Notificavel sistema = new Sistema("Twitter");

		notificador.add(pessoa);
		notificador.add(sistema);
	}

	@Before
	public void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		notificador = new NotificadorDAOHibernate(session);
		load();

		tx.commit();
	}

	@After
	public void setDown() {
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
