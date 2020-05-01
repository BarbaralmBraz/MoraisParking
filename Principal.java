package visao;

import java.util.Scanner;

import modelo.Aluno;
import controle.AlunoEventos;
import controle.BaseDados;
import controle.CursoEventos;
import controle.VeiculoEventos;
import modelo.Curso;
import modelo.TipoVeiculo;
import modelo.Veiculo;

import controle.VagaEventos;
public class Principal {
	
	static VagaEventos controleVagas = new VagaEventos();

	private static void principalVagas() {
		
		
		Scanner teclado = new Scanner(System.in);
		String tipoVeiculo, placa;
		int numeroVaga, opcao, quantVagas;
		boolean executar = true;
		
		while(executar) {
			System.out.println("1. Ocupar vaga ");
			System.out.println("2. Liberar vaga ");
			System.out.println("3. Criar vagas ");
			System.out.println("4. Listar vagas ");
			System.out.println("5. Sair ");
			
			System.out.print("Escolha uma op��o: " );
			opcao = Integer.valueOf(teclado.nextLine().trim());
			
			switch(opcao) {
				case 1:
					System.out.print("Informe o tipo de ve�culo: ");
					tipoVeiculo = teclado.nextLine();
					System.out.print("Informe a placa do ve�culo: ");
					placa = teclado.nextLine();
					System.out.print("Informe o n�mero da vaga: ");
					numeroVaga = Integer.valueOf(teclado.nextLine().trim());
					
					try {
						controleVagas.ocupaVaga(placa, numeroVaga, tipoVeiculo);
						System.out.println("Vaga ocupada");
					}  catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 2: 
					System.out.print("Informe o tipo de ve�culo: ");
					tipoVeiculo = teclado.nextLine();
					System.out.print("Informe o n�mero da vaga: ");
					numeroVaga = Integer.valueOf(teclado.nextLine().trim());
					
					try {
						controleVagas.liberarVaga(numeroVaga, tipoVeiculo);
						System.out.println("Vaga liberada");
					}  catch(Exception e) {
						System.out.println(e);
					}
					break;
				case 3:
					System.out.print("Criar quantas vagas: ");
					quantVagas = Integer.valueOf(teclado.nextLine().trim());
					System.out.print("Qual tipo de vaga: ");
					tipoVeiculo = teclado.nextLine();
					
					try {
						controleVagas.criarVagas(tipoVeiculo, quantVagas);
						System.out.println("Vagas criadas");
					}  catch(Exception e) {
						System.out.println(e);
					}
					break;
					
				case 4:
					System.out.print("Tipo de vagas: ");
					tipoVeiculo = teclado.nextLine();
					
					try {
						String saida;
						saida = controleVagas.listarVagas(tipoVeiculo);
						System.out.println(saida);
					}  catch(Exception e) {
						System.out.println(e);
					}
					break;
					
					
				case 5:
					executar = false;
					break;
				default:
					System.out.print("op��o invalida");
					break;
	
			}
	   	}
			
	}
	
	public static void main (String[] args) {


		//Menu principal
		Scanner teclado = new Scanner(System.in);

		while(true) {
			System.out.println("1. Cadastrar um Curso");
			System.out.println("2. Cadastrar um Ve�culo");
			System.out.println("3. Cadastrar um Aluno");
			System.out.println("4. Monitorar Vagas");
			System.out.println("5. Sair");

			System.out.print("Escolha uma op��o: " );
			int opcao = Integer.valueOf(teclado.nextLine().trim());


			if(opcao==1) {

				//Cadastro de Curso
				while(true) {

					String voltar = ("");

					System.out.println("1. Cadastrar um Curso");
					System.out.println("2. Listar Cursos");
					System.out.println("3. Sair");

					System.out.print("Escolha uma op��o: " );
					int escolha = Integer.valueOf(teclado.nextLine().trim());

					CursoEventos ce = new CursoEventos();

					if(escolha==1) {
						System.out.println("");
						System.out.print("Nome do Curso: " );
						String nomeCurso = teclado.nextLine().trim();
						Curso  curso     = new Curso();
						curso.setNome(nomeCurso);
						ce.cadastrarCurso(curso);
						System.out.println("Curso Cadastrado!");
						System.out.println("Pressione qualquer tecla para voltar...");
						voltar = teclado.nextLine();
					} else if(escolha==2) {
						System.out.println("");
						for(Curso curso: ce.listarCurso()) {
							System.out.println("Id: " + String.valueOf(curso.getId()) + " Nome: " + curso.getNome());
						}
						System.out.println("");
						System.out.println("Pressione qualquer tecla para voltar...");
						voltar = teclado.nextLine();
					} else {
						break;
					}	
				}
			}
			if(opcao==2) {
				// Cadastro de ve�culo
				while (true) {
					System.out.println("1. Cadastrar um ve�culo");
					System.out.println("2. Listar Ve�culos");
					System.out.println("3. Sair");

					System.out.print("Escolha uma op��o: " );
					int escolha = Integer.valueOf(teclado.nextLine().trim());

					VeiculoEventos ve = new VeiculoEventos();

					if(escolha==1) {
						System.out.println("");
						System.out.println("Digite a placa do ve�culo: ");//Campo para placa do ve�culo
						String placa = teclado.nextLine().trim();
						Veiculo veiculo     = new Veiculo();
						veiculo.setPlaca(placa);
						ve.cadastrarVeiculo(veiculo);
						System.out.println("Escolha o tipo do ve�culo: ");
						for (TipoVeiculo tipoVeiculo : TipoVeiculo.values()) {// la�o para chamar a lista dos tipos de ve�culo
							System.out.println(String.valueOf(tipoVeiculo.getCodigo()) + ". "  + tipoVeiculo.getDescricao());
						}			
						System.out.print("Digite o Codigo do tipo do ve�culo: " );//Campo para digitar o c�digo do tipo do ve�culo.
						int cod = Integer.valueOf(teclado.nextLine().trim());

						for (TipoVeiculo tipoVeiculo: TipoVeiculo.values()) { //Varrendo a lista TipoVe�culo
							if(cod == tipoVeiculo.getCodigo()){
								veiculo.setTipoVeiculo(tipoVeiculo);
							}
						}
					}else if(escolha==2) {
						System.out.println("");
						for(Veiculo veiculo: ve.listarVeiculo()) {
							System.out.println("Placa: " + String.valueOf(veiculo.getPlaca()) + " Tipo: " + veiculo.getTipoVeiculo().getDescricao());
							}
							
						System.out.println("Ve�culo Cadastrado!");
					
					} else if (escolha==3){
							System.out.println("Sair!");
							break;
					} 	
				}		
			}	
			if(opcao==3) {
				//Cadastro de Aluno
				while(true) {
					System.out.println("1. Cadastrar um Aluno");
					System.out.println("2. Sair");

					System.out.print("Escolha uma op��o: " );
					int escolhaA = Integer.valueOf(teclado.nextLine().trim());

					AlunoEventos ae = new AlunoEventos();
					CursoEventos ce = new CursoEventos();
					VeiculoEventos ve = new VeiculoEventos();

					if(escolhaA==1) {
						System.out.println("");
						System.out.println("Nome do Aluno: ");//Campo do nome do aluno
						String nomeAluno = teclado.nextLine().trim();
						System.out.print("Matricula do Aluno: " );//Campo da matricula do aluno 
						int alunoMatricula = Integer.valueOf(teclado.nextLine().trim());
						System.out.println("");
						System.out.print("Vaga especial: " ); //Campo para identifica��o de vaga especial
						String areaEspecial = teclado.nextLine().trim();
						System.out.print("Curso do Aluno: " );//Campo para escolha do curso
						Aluno aluno = new Aluno ();
						for(Curso curso: ce.listarCurso()) {
							System.out.println("Id: " + String.valueOf(curso.getId()) + " Nome: " + curso.getNome());
						}
						System.out.print("Digite o Id do curso: " );//Campo do Id do curso digitado 
						int id = Integer.valueOf(teclado.nextLine().trim());
						Curso curso = new Curso ();
						for(Curso curso2: ce.listarCurso()) {//Varrendo a lista curso para comprar se o Id digitado corresponde ao Id do curso ja cadastrado anteriormente.
							if(id == curso.getId()){
								curso.setId(id);
							}
						}
						System.out.print("Digite a placa do carro: " );//Campo para escolha do curso
						String placa = teclado.nextLine().trim();
						for(Veiculo veiculo: ve.listarVeiculo()) {//Varrendo a lista veiculo para saber se o ve�culo j� est� cadastrado.
							if(placa == veiculo.getPlaca()){
								aluno.setVeiculo(veiculo);
							}
						}

						aluno.setAlunoNome(nomeAluno);
						aluno.setAlunoMatricula(alunoMatricula);
						aluno.setAreaEspecial(areaEspecial);
						ae.cadastrarAluno(aluno);
						System.out.println("Aluno Cadastrado!");
					}	
					else if(escolhaA==2){
						System.out.println("Sair!");
						break;
					}		
				}			
			}
			else if(opcao==4){
				principalVagas();
			}	
			
			
			else if(opcao==5){
				System.out.println("Sair!");
				break;
			}	

		}
	}
}


