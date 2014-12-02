package br.edu.si6.lab6.dao;

import br.edu.si6.lab6.bean.MotoristaTO;
import javax.persistence.EntityManager;

public class MotoristaDAO extends GenericDAO<MotoristaTO, Integer> {
	public MotoristaDAO(EntityManager em) {
		super(em);
	}

}
