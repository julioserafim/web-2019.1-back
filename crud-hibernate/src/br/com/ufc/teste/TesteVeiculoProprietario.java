package br.com.ufc.teste;

import br.com.ufc.dao.ProprietarioDAO;
import br.com.ufc.dao.VeiculoDAO;
import br.com.ufc.model.Proprietario;
import br.com.ufc.model.Veiculo;

public class TesteVeiculoProprietario {
	public static void main(String[] args) {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Cássio");
		proprietario.setTelefone("444444");
		proprietario.setEmail("qualquercoisa@gmail.com");
		proprietarioDAO.adicionar(proprietario);
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Veiculo veiculo = new Veiculo();
		veiculo.setMarca("Toyota");
		veiculo.setModelo("HB20");
		veiculo.setDataFabricacao("2012");
		veiculo.setProprietario(proprietario);
		
		veiculoDAO.adicionar(veiculo);
		
		
		
		
	}
}
