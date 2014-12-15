/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.si6.lab6.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.edu.si6.lab6.bean.MotoristaTO;
import br.edu.si6.lab6.bean.ViagemTO;
import br.edu.si6.lab6.dao.MotoristaDAO;
import br.edu.si6.lab6.dao.ViagemDAO;
import br.edu.si6.lab6.orm.HibernateUtil;

@ManagedBean
public class ViagemCtrl {

	private ViagemTO to;
	private ViagemDAO dao;
	private DataModel tablemodel;
	private final EntityManager em;
	private List<MotoristaTO> motoristas;

	public ViagemCtrl() {
		em = HibernateUtil.getEntityManager();
		to = new ViagemTO();
		dao = new ViagemDAO(em);
	}

	public List<MotoristaTO> getMotoristas() {
		MotoristaDAO dao = new MotoristaDAO(em);
		motoristas = dao.getAll();
		return motoristas;
	}

	public void setMotoristas(List<MotoristaTO> motoristas) {
		this.motoristas = motoristas;
	}

	public ViagemTO getTo() {
		return to;
	}

	public void setTo(ViagemTO to) {
		this.to = to;
	}

	public DataModel getTablemodel() {

		tablemodel = new ListDataModel(dao.getAll());
		return tablemodel;
	}

	public void setTablemodel(DataModel tablemodel) {
		this.tablemodel = tablemodel;
	}

	public void novaViagem() {
		to = new ViagemTO();
	}

	public void selecionarViagem() {
		to = (ViagemTO) tablemodel.getRowData();
		System.out.println(to);

	}

	public String telaListar() {
		return "/viagem/lista";
	}

	public String telaNovo() {
		return "/viagem/novo";
	}

	public String telaExcluir() {
		return "/viagem/excluir";
	}

	public String telaEditar() {
		return "/viagem/editar";
	}

	public String salvaViagem() {
		if (dao.salvar(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String editaViagem() {
		if (dao.update(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String excluiViagem() {
		if (dao.delete(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Excluído com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

}
