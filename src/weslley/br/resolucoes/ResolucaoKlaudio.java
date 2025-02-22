package weslley.br.resolucoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import weslley.br.models.Aluno;

public class ResolucaoKlaudio {

	public void menu() {
		List<Aluno> bancoAlunos = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("*************************");
			System.out.println("O que você deseja: ");
			System.out.println("1 - Cadastrar \n2 - Consultar \n3 - Atualizar \n4 - Deletar ");
			int opcaoSelecionada = scan.nextInt();
			scan.nextLine();

			switch (opcaoSelecionada) {
			case 1:
				cadastrarAluno(bancoAlunos, scan);
				break;
			case 2:
				consultarAluno(bancoAlunos, scan);
				break;
			case 3:
				atualizarAluno(bancoAlunos, scan);
				break;
			case 4:
				deletarAluno(bancoAlunos, scan);
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
	}

	private static void cadastrarAluno(List<Aluno> bancoAlunos, Scanner scan) {
	    System.out.println("\n ********** CADASTRO ************* ");
	    Aluno novoAluno = new Aluno();

	    while (true) {
	        lerDadosAluno(novoAluno, scan); 
	        // Verifica se o aluno foi cadastrado corretamente
	        if (novoAluno.getId() != null && novoAluno.getNome() != null && novoAluno.getIdade() != null && novoAluno.getNomeCurso() != null) {
	            bancoAlunos.add(novoAluno);
	            System.out.println("Aluno cadastrado com sucesso!");
	            break; // Sai do loop se tudo ocorrer bem
	        } else {
	            System.out.println("Erro ao cadastrar aluno. Tente novamente.");
	        }
	    }
	}

	private static void consultarAluno(List<Aluno> bancoAlunos, Scanner scan) {
		System.out.println("\n ********** CONSULTA ************* ");
		if (verificaBanco(bancoAlunos)) {
			System.out.print("Digite o nome que deseja consultar: ");
			String nomeConsultado = scan.nextLine();
			Aluno alunoEncontrado = buscarAlunoPorNome(bancoAlunos, nomeConsultado);
			if (alunoEncontrado != null) {
				System.out.println("Aluno encontrado: " + alunoEncontrado);
			} else {
				System.out.println("Não tem ninguém com esse nome :/");
			}
		}
	}

	private static void atualizarAluno(List<Aluno> bancoAlunos, Scanner scan) {
		System.out.println("\n ********** ATUALIZA ************* ");
		if (verificaBanco(bancoAlunos)) {
			System.out.print("Digite o nome quem deseja atualizar: ");
			String nomeSelecionado = scan.nextLine();
			Aluno aluno = buscarAlunoPorNome(bancoAlunos, nomeSelecionado);

			if (aluno != null) {
				while (true) {
					try {
						System.out.print("Novo nome: ");
						aluno.setNome(scan.nextLine());

						System.out.print("Nova Idade: ");
						aluno.setIdade(scan.nextInt());
						scan.nextLine();

						System.out.print("Novo Curso: ");
						aluno.setNomeCurso(scan.nextLine());

						System.out.println("Aluno atualizado com sucesso!");
						break;
					} catch (Exception e) {
						System.out.println("Erro, tente novamente.");
						scan.nextLine();
					}
				}
			} else {
				System.out.println("Não tem ninguém com esse nome :/");
			}
		}
	}

	private static void deletarAluno(List<Aluno> bancoAlunos, Scanner scan) {
		System.out.println("\n ********** DELETA ************* ");
		if (verificaBanco(bancoAlunos)) {
			while (true) {
				try {
					System.out.print("Digite o ID quem deseja deletar: ");
					Long idSelecionado = scan.nextLong();
					scan.nextLine();

					Aluno alunoExcluido = null;
					for (Aluno aluno : bancoAlunos) {
						if (aluno.getId().equals(idSelecionado)) {
							alunoExcluido = aluno;
							break;
						}
					}

					if (alunoExcluido != null) {
						bancoAlunos.remove(alunoExcluido);
						System.out.println("Removido com sucesso :D");
					} else {
						System.out.println("Não tem ninguém com esse ID :/");
					}
					break;
				} catch (Exception e) {
					System.out.println("Erro, tente novamente.");
					scan.nextLine();
				}
			}
		}
	}

	private static Aluno buscarAlunoPorNome(List<Aluno> bancoAlunos, String nome) {
		for (Aluno aluno : bancoAlunos) {
			if (aluno.getNome().equalsIgnoreCase(nome)) {
				return aluno;
			}
		}
		return null;
	}

	private static boolean verificaBanco(List<Aluno> banco) {
		if (banco.isEmpty()) {
			System.out.println("O banco está vazio.");
			return false;
		}
		return true;
	}

	private static void lerDadosAluno(Aluno aluno, Scanner scan) {
		try {
			System.out.print("ID: ");
			aluno.setId(scan.nextLong());
			scan.nextLine();

			System.out.print("Nome: ");
			aluno.setNome(scan.nextLine());
			scan.nextLine();

			System.out.print("Idade: ");
			aluno.setIdade(scan.nextInt());
			scan.nextLine(); 

			System.out.print("Nome do Curso: ");
			aluno.setNomeCurso(scan.nextLine());
		} catch (Exception e) {
			System.out.println("Erro ao ler os dados do aluno: " + e.getMessage());
			scan.nextLine(); // Limpa o buffer em caso de erro
		}

	}
}