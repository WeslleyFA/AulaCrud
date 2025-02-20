package weslley.br.resolucoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import weslley.br.models.Aluno;

public class VersaoBrutaWeslley {
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		Integer opcaoSelecionada;
		List<Aluno> bancoAlunos = new ArrayList<>();
		
		while(true) {
			System.out.println("*************************");
			System.out.println("O que você deseja: ");
			System.out.println("1 - Cadastrar \n2 - Consultar \n3 - Atualizar \n4 - Deletar ");
			opcaoSelecionada = scan.nextInt();

			switch (opcaoSelecionada) {
			case 1:
				cadastrarAluno(bancoAlunos);
				break;
			case 2:
				consultarAluno(bancoAlunos);
				break;
			case 3:
				atualizarAluno(bancoAlunos);
				break;
			case 4:
				deletarAluno(bancoAlunos);
				break;
			default:
				System.out.println("Opção Invalída!");
			}
		}
	}
	
	private static void cadastrarAluno(List<Aluno> bancoAlunos) {
		System.out.println("\n ********** CADASTRO ************* ");
		
		try {
			Aluno novoAluno = new Aluno();
			Scanner s = new Scanner(System.in);
			
			System.out.println("ID: ");
			novoAluno.setId(s.nextLong());
			
			System.out.println("Nome: ");
			novoAluno.setNome(s.next());
			
			System.out.println("Idade: ");
			novoAluno.setIdade(s.nextInt());
			
			System.out.println("Nome do Curso: ");
			novoAluno.setNomeCurso(s.next());
			
			bancoAlunos.add(novoAluno);	
		}catch (Exception e) {
			System.out.println("Voce cometeum algum erro, cadastro encerrado");
		}
		
	}

	private static void consultarAluno(List<Aluno> bancoAlunos) {
		System.out.println("\n ********** CONSULTA ************* ");
		
		verificaBanco(bancoAlunos);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome que deseja consultar: ");
		String nomeConsultado = s.next();
		
		Boolean achouAlguem = false;
		
		for(Aluno aluno : bancoAlunos) {
			if(aluno.getNome().equalsIgnoreCase(nomeConsultado)) {
				achouAlguem = true;
				System.out.println(aluno);
			}				
		}
		
		if(!achouAlguem) {
			System.out.println("Não tem ngm com esse nome :/");
		}
		
	}

	private static void atualizarAluno(List<Aluno> bancoAlunos) {
		System.out.println("\n ********** ATUALIZA ************* ");
		
		verificaBanco(bancoAlunos);
		
		Scanner s = new Scanner(System.in);
		
		for(Aluno aluno: bancoAlunos) {
			System.out.println(aluno);
		}
		
		System.out.println("Digite o nome quem deseja atualizar: ");
		String nomeSelecionado = s.next();
		
		Boolean achouAlguem = false;
		
		for(Aluno aluno : bancoAlunos) {
			if(aluno.getNome().equalsIgnoreCase(nomeSelecionado)) {
				achouAlguem = true;
				
				System.out.println("Digite o novo nome: ");
				aluno.setNome(s.next());
				
				System.out.println("Digite a nova Idade: ");
				aluno.setIdade(s.nextInt());
				
				System.out.println("Digite o novo Curso: ");
				aluno.setNomeCurso(s.next());	
			}				
		}
		
		if(!achouAlguem) {
			System.out.println("Não tem ngm com esse nome :/");
		}
	}

	private static void deletarAluno(List<Aluno> bancoAlunos) {
		System.out.println("\n ********** DELETA ************* ");	
		Scanner s = new Scanner(System.in);
		
		if(!verificaBanco(bancoAlunos)) return;
		
		for(Aluno aluno: bancoAlunos) {
			System.out.println(aluno);
		}
		
		System.out.println("Digite o ID quem deseja deletar: ");
		Long idSelecionado = s.nextLong();
		
		Boolean achouAlguem = false;
		Aluno alunoExcluido = new Aluno();
		
		for(Aluno aluno : bancoAlunos) {
			if(aluno.getId() == idSelecionado) {
				achouAlguem = true;	
				alunoExcluido = aluno;	
			}				
		}
		
		if(achouAlguem) {
			bancoAlunos.remove(alunoExcluido);
			System.out.println("Removido com sucesso :D");
		}
	
		
		for(Aluno aluno: bancoAlunos) {
			System.out.println(aluno);
		}
		
		
		if(!achouAlguem) {
			System.out.println("Não tem ngm com esse nome :/");
		}

	}
	
	private static Boolean verificaBanco(List<Aluno> banco) {
		if(banco.size() == 0) {
			System.out.println("O banco está vazio. ");
			return false;
		} else 
			return true;
	}
}
