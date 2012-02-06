package br.com.renan.infra;

import java.util.List;

import org.hibernate.Session;

import br.com.renan.domain.Garagem;
import br.com.renan.domain.Veiculo;

public class VeiculoDAOHibernate implements Garagem {

	private Session session;

	public VeiculoDAOHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> lista() {
		String hql = "FROM br.com.renan.domain.Veiculo";
		return session.createQuery(hql).list();
	}

	public void compra(Veiculo veiculo) {
		session.save(veiculo);
	}

}