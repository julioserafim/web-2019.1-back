package br.com.ufc.teste;

import br.com.ufc.dao.ProprietarioDAO;
import br.com.ufc.dao.VeiculoDAO;
import br.com.ufc.model.Proprietario;
import br.com.ufc.model.Veiculo;

public class TesteVeiculoProprietario {
	public static void main(String[] args) {
		ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
		
//		Proprietario proprietario = new Proprietario();
//		proprietario.setNome("Cássio");
//		proprietario.setTelefone("444444");
//		proprietario.setEmail("qualquercoisa@gmail.com");
//		proprietarioDAO.adicionar(proprietario);
		
	Proprietario proprietario2 = proprietarioDAO.buscarPorId(11L);
//		proprietario2.setNome("PROPRIETARIO3");
//		proprietario2.setTelefone("777779");
//		proprietario2.setEmail("emailprop3@gmail.com");
//		proprietarioDAO.adicionar(proprietario2);
//		
		
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		Veiculo veiculo = veiculoDAO.buscarPorId(12L);
		
//	veiculo.setMarca("Toyota2");
//	veiculo.setModelo("HB202");
//	veiculo.setDataFabricacao("2011");
		
		veiculo.setProprietario(proprietario2);
		
		veiculoDAO.adicionar(veiculo);
		
		
		
		
	}
}
