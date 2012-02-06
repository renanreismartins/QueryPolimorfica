package br.com.renan.domain;

import java.util.List;

public interface Garagem {

	public List<Veiculo> lista();

	public void compra(Veiculo veiculo);
	
}