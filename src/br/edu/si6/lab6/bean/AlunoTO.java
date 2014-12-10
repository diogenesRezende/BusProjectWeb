package br.edu.si6.lab6.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class AlunoTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "sequence", sequenceName = "seq_aluno", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Id
	private int id = 0;
	private String nome = null;
	private String celular = null;
	private String endereco = null;
	private int num_end = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao", nullable = false)
	private InstituicaoTO instituicao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno", targetEntity = Viagem_AlunoTO.class)
	private Set<Viagem_AlunoTO> viagem_AlunoTO;

	public AlunoTO(String nome, String celular, String endereco, int num_end) {
		super();
		this.nome = nome;
		this.celular = celular;
		this.endereco = endereco;
		this.num_end = num_end;
	}

	public AlunoTO() {
		super();
	}

	public InstituicaoTO getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoTO instituicao) {
		this.instituicao = instituicao;
	}

	public Set<Viagem_AlunoTO> getViagem_AlunoTO() {
		return viagem_AlunoTO;
	}

	public void setViagem_AlunoTO(Set<Viagem_AlunoTO> viagem_AlunoTO) {
		this.viagem_AlunoTO = viagem_AlunoTO;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
