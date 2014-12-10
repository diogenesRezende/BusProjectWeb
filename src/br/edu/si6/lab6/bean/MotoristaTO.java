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
@Table(name = "motorista")
public class MotoristaTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "sequence", sequenceName = "seq_motorista", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Id
	private int id;
	private String nome = null;
	private String celular = null;
	private String categoriaCnh = null;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motorista", targetEntity = ViagemTO.class)
	private Set<ViagemTO> viagem;

	public MotoristaTO(int id, String nome, String celular, String categoriaCnh) {
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.categoriaCnh = categoriaCnh;
	}

	public MotoristaTO() {
	}

	public Set<ViagemTO> getViagem() {
		return viagem;
	}

	public void setViagem(Set<ViagemTO> viagem) {
		this.viagem = viagem;
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

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
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
