package modelo;

public class Veiculo {
	
	//Abstraindo o objeto Aluno
	private String placa;
	private int id; //Representação de valor único para cada registro de cada veículo
	private TipoVeiculo tipoVeiculo; //O tipo do veículo é uma caracteristica de veículo.
	
	public Veiculo() {
		
	}
	
	public String getPlaca() {
		return placa;		
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	
	
	public String toString() {
		return "\n Placa do veículo:" + this.placa +  ",\n Id do veículo:" + String.valueOf(this.id) + ",\n Tipo do veículo:" + this.tipoVeiculo.getDescricao();
	}

	
	
	
	
	
	
	

}
