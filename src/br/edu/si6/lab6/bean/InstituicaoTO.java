package br.edu.si6.lab6.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "instituicao")
public class InstituicaoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "sequence", sequenceName = "seq_instituicao", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Id
	private int id = 0;
	private String nome = null;
	private String email = null;
	private String telefone = null;
	private String cidade = null;
	private String endereco = null;
	private String bairro = null;
	private int num_end = 0;

	public InstituicaoTO(int id, String nome, String email, String telefone,
			String cidade, String endereco, String bairro, int num_end) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cidade = cidade;
		this.endereco = endereco;
		this.bairro = bairro;
		this.num_end = num_end;

	}

	public InstituicaoTO() {
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", targetEntity = AlunoTO.class)
	private Set<AlunoTO> aluno;

	public Set<AlunoTO> getAluno() {
		return aluno;
	}

	public void setAluno(Set<AlunoTO> aluno) {
		this.aluno = aluno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNum_end() {
		return num_end;
	}

	public void setNum_end(int num_end) {
		this.num_end = num_end;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return id;
	}
}
