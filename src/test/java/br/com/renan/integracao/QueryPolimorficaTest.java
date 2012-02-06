package br.com.renan.integracao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.renan.domain.Garagem;
import br.com.renan.domain.Veiculo;

public class QueryPolimorficaTest {
	
	private Garagem garagem;

	@Test
	public void deveRetornarDoisVeiculos() {
		List<Veiculo> veiculos = garagem.list();
		assertEquals(2, veiculos.size());
	}
	
}
