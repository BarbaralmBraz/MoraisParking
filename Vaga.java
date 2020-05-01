package modelo;

public class Vaga {

	private int numeroVaga;
	private String placaVeiculo;
	private boolean disponivel;

	
	
	public Vaga(int numeroVaga) {
		super();
		this.numeroVaga = numeroVaga;
		this.placaVeiculo = "";
		this.disponivel = true;
	}
	
	
	
	
	
	public int getNumeroVaga() {
		return this.numeroVaga;
	}
	
	
	
	
	
	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}
	
	
	
	
	
	public String getPlacaVeiculo() {
		return this.placaVeiculo;
	}
	
	
	
	
	
	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}
	
	
	
	
	
	public boolean isDisponivel() {
		return this.disponivel;
	}
	
	
	
	
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	
	private String retornaDisponibilidade() {
		if (isDisponivel()) {
			return "Disponivel";
		}
		else { 
			return "Ocupada";
		}
		
	}
	
	
	
	public String toString() {
		return "Vaga: " + String.valueOf(this.numeroVaga) + " - " + retornaDisponibilidade();
	
	}
}
