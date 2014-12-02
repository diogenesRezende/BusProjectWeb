package br.edu.si6.lab6.dao;

import br.edu.si6.lab6.bean.InstituicaoTO;
import javax.persistence.EntityManager;

public class InstituicaoDAO extends GenericDAO<InstituicaoTO, Integer> {
	public InstituicaoDAO(EntityManager em) {
		super(em);
	}
}
