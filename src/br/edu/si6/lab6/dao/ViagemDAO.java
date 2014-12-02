package br.edu.si6.lab6.dao;

import br.edu.si6.lab6.bean.ViagemTO;
import javax.persistence.EntityManager;

public class ViagemDAO extends GenericDAO<ViagemTO, Integer> {
	public ViagemDAO(EntityManager em) {
		super(em);
	}
}
