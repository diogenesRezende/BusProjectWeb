package br.edu.si6.lab6.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno_viagem")
@IdClass(value = Viagem_AlunoPK.class)
public class Viagem_AlunoTO {

	@ManyToOne
	@JoinColumn(name = "id_aluno", nullable = false)
	@Id
	private AlunoTO aluno;
	@ManyToOne
	@JoinColumn(name = "id_viagem", nullable = false)
	@Id
	private ViagemTO viagem;

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

	public ViagemTO getViagem() {
		return viagem;
	}

	public void setViagem(ViagemTO viagem) {
		this.viagem = viagem;
	}

}
