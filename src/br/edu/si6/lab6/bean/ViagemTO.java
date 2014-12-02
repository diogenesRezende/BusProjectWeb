package br.edu.si6.lab6.bean;

import java.sql.Date;
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
@Table(name = "viagem")
public class ViagemTO {

	@SequenceGenerator(name = "sequence", sequenceName = "seq_viagem", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Id
	private int id = 0;
	private Date data = null;
	private String origem;
	private String destino;

	@ManyToOne
	@JoinColumn(name = "id_motorista", nullable = false)
	private MotoristaTO motorista;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "viagem", targetEntity = Viagem_AlunoTO.class)
	private Set<Viagem_AlunoTO> viagem_Aluno;

	public Set<Viagem_AlunoTO> getViagem_Aluno() {
		return viagem_Aluno;
	}

	public void setViagem_Aluno(Set<Viagem_AlunoTO> viagem_Aluno) {
		this.viagem_Aluno = viagem_Aluno;
	}

	public MotoristaTO getMotorista() {
		return motorista;
	}

	public void setMotorista(MotoristaTO motorista) {
		this.motorista = motorista;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
}
