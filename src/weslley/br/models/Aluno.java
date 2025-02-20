package weslley.br.models;

public class Aluno {
	
	private Long id;
	private String nome;
	private Integer idade;
	private String nomeCurso;
	
	public Aluno(Long id, String nome, Integer idade, String nomeCurso) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.nomeCurso = nomeCurso;
	}

	public Aluno() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", idade=" + idade + ", nomeCurso=" + nomeCurso + "]";
	}
}
