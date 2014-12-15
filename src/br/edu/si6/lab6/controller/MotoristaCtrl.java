package br.edu.si6.lab6.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;

import br.edu.si6.lab6.bean.MotoristaTO;
import br.edu.si6.lab6.dao.MotoristaDAO;
import br.edu.si6.lab6.orm.HibernateUtil;

@ManagedBean
public class MotoristaCtrl {

	private MotoristaTO to;
	private MotoristaDAO dao;
	private DataModel tablemodel;
	private final EntityManager em;

	public MotoristaCtrl() {
		em = HibernateUtil.getEntityManager();
		to = new MotoristaTO();
		dao = new MotoristaDAO(em);
	}

	public MotoristaTO getTo() {
		return to;
	}

	public void setTo(MotoristaTO to) {
		this.to = to;
	}

	public DataModel<MotoristaTO> getTablemodel() {
		dao = new MotoristaDAO(this.em);
		tablemodel = new ListDataModel<MotoristaTO>(dao.getAll());
		return tablemodel;
	}

	public void setTablemodel(DataModel<MotoristaTO> tablemodel) {
		this.tablemodel = tablemodel;
	}

	public void novoMotorista() {
		to = new MotoristaTO();
	}

	public void selecionarMotorista() {
		to = (MotoristaTO) tablemodel.getRowData();
		System.out.println(to);

	}

	public String telaListar() {
		return "/motorista/lista";
	}

	public String telaNovo() {
		return "/motorista/novo";
	}

	public String telaExcluir() {
		return "/motorista/excluir";
	}

	public String telaEditar() {
		return "/motorista/editar";
	}

	public String salvaMotorista() {
		if (dao.salvar(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String editaMotorista() {
		if (dao.update(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String excluiMotorista() {
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
