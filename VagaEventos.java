package controle;

import controle.BaseDados;
import java.util.List;



import modelo.Vaga;


public class VagaEventos {

	BaseDados base = new BaseDados();
	public void criarVagas(String tipoVaga, int numeroVagas) {
		base.adicionarVagas(tipoVaga, numeroVagas);
	}
	
	private boolean vagaDisponivel(Vaga vaga) {
		return vaga.isDisponivel();
	}
	
	public void ocupaVaga (String placa, int numeroVaga, String tipoVeiculo) {
		
		Vaga vaga = base.retornaVaga(numeroVaga, tipoVeiculo);
		
		if (vaga != null) {
			if (vagaDisponivel(vaga)) {
				vaga.setDisponivel(false);
				vaga.setPlacaVeiculo(placa);
				base.alteraVaga(numeroVaga, vaga, tipoVeiculo);
			}
			else {
			  throw	new IllegalArgumentException("Vaga está ocupada");
			}
			
			}
		
		else {
			throw	new IllegalArgumentException("Vaga não existe");
			
		}
	}
		
		
		public void liberarVaga (int numeroVaga, String tipoVeiculo) {
			
			Vaga vaga = base.retornaVaga(numeroVaga, tipoVeiculo);
			
			if (vaga != null) {
				if (!vagaDisponivel(vaga)) {
					vaga.setDisponivel(true);
					base.alteraVaga(numeroVaga, vaga, tipoVeiculo);
				}
				else {
				  throw	new IllegalArgumentException("Vaga está livre");
				}
				
				}
			
			else {
				throw	new IllegalArgumentException("Vaga não existe");
				
			}

		}
		
		public String listarVagas(String tipoVaga) {
			List<Vaga> vagas;
			String saida;
			int vagasLinha;
			
			vagasLinha = 0;
			vagas = base.retornaLista(tipoVaga);
			saida = "";
			
			if(vagas != null) {
				for(Vaga vaga : vagas) {
					saida += vaga.toString();
					if(vagasLinha++ == 3) {
						saida += "\n";
						vagasLinha = 0;
					}
					else {
						saida += "  ";
					}
				}
			
			}
			else {
				throw	new IllegalArgumentException("Vagas inexistentes");
			}
			
			return saida;
		}
}

