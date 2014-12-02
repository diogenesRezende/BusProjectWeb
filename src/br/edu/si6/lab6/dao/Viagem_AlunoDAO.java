package br.edu.si6.lab6.dao;

import br.edu.si6.lab6.bean.Viagem_AlunoTO;
import javax.persistence.EntityManager;

public class Viagem_AlunoDAO extends GenericDAO<Viagem_AlunoTO, Integer> {
	public Viagem_AlunoDAO(EntityManager em) {
		super(em);
	}
}
