package br.edu.si6.lab6.bean;

import java.io.Serializable;

public class Viagem_AlunoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private ViagemTO viagem;

	private AlunoTO aluno;

	public Viagem_AlunoPK() {
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Viagem_AlunoTO) {
			Viagem_AlunoTO viagem_Aluno = (Viagem_AlunoTO) obj;

			if (!viagem_Aluno.getAluno().equals(aluno)) {
				return false;
			}

			if (!viagem_Aluno.getViagem().equals(viagem)) {
				return false;
			}

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return aluno.hashCode() + viagem.hashCode();

	}

	public ViagemTO getViagem() {
		return viagem;
	}

	public void setViagem(ViagemTO viagem) {
		this.viagem = viagem;
	}

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

}
