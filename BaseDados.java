package controle;

import java.util.ArrayList;//ArrayLista é uma extensão de List (tem algo a mais)
import java.util.List;

import modelo.Aluno;
import modelo.Curso;
import modelo.Veiculo;

import modelo.Vaga;

public class BaseDados {

	private List<Vaga> vagasCarro = new ArrayList<Vaga>(); 
	private List<Vaga> vagasMoto = new ArrayList<Vaga>(); 
	private List<Vaga> vagasOnibus = new ArrayList<Vaga>(); 
	
	public static List<Curso> listaCurso = new ArrayList<Curso> (); //static por que os dados serão guardados em memória e poderão ser acessados depois. Esta List serve para armazenar(guardar) os cursos(objeto) na classe BancoDados.
	private static int idCurso = 0;
	
	// Construtor vazio, porque so serve para representar os dados desta classe, ele é inacessível.
	public BaseDados() {	
	}
	
	//método simples para id curso
	public static int proximoIdCurso() {
		idCurso = idCurso + 1;
		return idCurso;
	}
	
	//Criando lista de alunos
	public static List<Aluno> listaAluno = new ArrayList<Aluno> (); 
	private static int alunoMatricula=0;
	
	
	public static int proximaMatriculaAluno() {
		alunoMatricula = alunoMatricula +1;
		return alunoMatricula;	
	}
	
	//Criando lista de veículos
		public static List<Veiculo> listaVeiculo = new ArrayList<Veiculo> (); 
		private static int idVeiculo=0;
		
		
		public static int proximoIdVeiculo() {
			idVeiculo = idVeiculo +1;
			return idVeiculo;	
		}
		
		
		public List<Vaga> retornaLista(String tipoVaga) {
			String tipoVagaMinusculo = tipoVaga.toLowerCase();
			if (tipoVagaMinusculo.equals("c")) {
				return vagasCarro;
			}
			
			
			else if (tipoVagaMinusculo.equals("m")) {
				return vagasMoto;
			}
			
			else if (tipoVagaMinusculo.equals("o")) {
				return vagasOnibus;
			}
			
			else {
				return null;
			}
		}
		
		public void adicionarVagas(String tipoVaga, int numeroVagas) {
			
			List<Vaga> lista = retornaLista(tipoVaga);
			int numeroElementos = lista.size();
			for (int i = 0; i < numeroVagas; i++ ) {
				Vaga vaga = new Vaga(numeroElementos); 
				lista.add(numeroElementos++, vaga);
			}
		}
		
		public void alteraVaga(int numeroVaga, Vaga vaga, String tipoVaga) {
			
			List<Vaga> lista = retornaLista(tipoVaga);
			lista.set(numeroVaga, vaga);
			
		}
		
		public Vaga retornaVaga(int numeroVaga, String tipoVaga) {
			
			List<Vaga> lista = retornaLista(tipoVaga);
			Vaga retorno = lista.get(numeroVaga);
			return retorno;
		}
	
	
		
			
		}

