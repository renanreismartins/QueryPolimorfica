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
	
	public List<Veiculo> lista() {
		return null;
	}

	public void compra(Veiculo veiculo) {
		session.save(veiculo);
	}
	
}