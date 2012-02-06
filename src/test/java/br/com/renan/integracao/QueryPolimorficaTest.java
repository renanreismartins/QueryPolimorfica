package br.com.renan.integracao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.renan.domain.Carro;
import br.com.renan.domain.Garagem;
import br.com.renan.domain.Moto;
import br.com.renan.domain.Veiculo;

public class QueryPolimorficaTest {
	
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
}
