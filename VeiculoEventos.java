package controle;

import java.util.List;

import controle.BaseDados;

import modelo.Veiculo;


public class VeiculoEventos {
	
	//Esta classe contempla todos os m�todos que envolver�o a classe Veiculo.
	
	
	
	public VeiculoEventos () {
		
	}
	
	public void cadastrarVeiculo(Veiculo veiculo) {
		if(veiculo!= null) {
			veiculo.setId(BaseDados.proximoIdVeiculo());
			BaseDados.listaVeiculo.add(veiculo);
		}
	}
	
	public List<Veiculo> listarVeiculo(){
		return BaseDados.listaVeiculo;
	}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

