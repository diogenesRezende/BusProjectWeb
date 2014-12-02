package br.edu.si6.lab6.dao;

import br.edu.si6.lab6.bean.AlunoTO;
import javax.persistence.EntityManager;

public class AlunoDAO extends GenericDAO<AlunoTO, Integer> {
	public AlunoDAO(EntityManager em) {
		super(em);
	}

}
