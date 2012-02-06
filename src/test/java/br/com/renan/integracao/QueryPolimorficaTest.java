package br.com.renan.integracao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.renan.domain.Carro;
import br.com.renan.domain.Garagem;
import br.com.renan.domain.Moto;
import br.com.renan.domain.Veiculo;
import br.com.renan.infra.HibernateUtil;
import br.com.renan.infra.VeiculoDAOHibernate;

public class QueryPolimorficaTest {
	private Session session;

	private Garagem garagem;

	@Test
	public void deveRetornarDoisVeiculos() {
		List<Veiculo> veiculos = garagem.lista();
		assertEquals(2, veiculos.size());
	}

	private void load() {
		Veiculo carro = new Carro("XXX-9999");
		Veiculo moto = new Moto("YYY-9999");

		garagem.compra(carro);
		garagem.compra(moto);
	}

	@Before
	public void setUp() {
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		garagem = new VeiculoDAOHibernate(session);
		load();
		
		tx.commit();
	}
	
	@After
	public void setDown() {
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
}
