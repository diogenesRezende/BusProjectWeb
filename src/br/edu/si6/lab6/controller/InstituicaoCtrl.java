package br.edu.si6.lab6.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.edu.si6.lab6.bean.InstituicaoTO;
import br.edu.si6.lab6.dao.InstituicaoDAO;
import br.edu.si6.lab6.orm.HibernateUtil;

@ManagedBean
public class InstituicaoCtrl {

	private InstituicaoTO to;
	private InstituicaoDAO dao;
	private DataModel tablemodel;
	private final EntityManager em = HibernateUtil.getEntityManager();

	public InstituicaoCtrl() {
		to = new InstituicaoTO();
		dao = new InstituicaoDAO(this.em);
	}

	public InstituicaoTO getTo() {
		return to;
	}

	public void setTo(InstituicaoTO to) {
		this.to = to;
	}

	public DataModel<InstituicaoTO> getTablemodel() {
		tablemodel = new ListDataModel<InstituicaoTO>(dao.getAll());
		System.out.println("entrou na condiçao!");
		return tablemodel;
	}

	public void setTablemodel(DataModel<InstituicaoTO> tablemodel) {
		this.tablemodel = tablemodel;
	}

	public void novaInstituicao() {
		to = new InstituicaoTO();
	}

	public void selecionarInstituicao() {
		to = (InstituicaoTO) tablemodel.getRowData();
		System.out.println(to);
	}

	public String telaListar() {
		return "/instituicao/lista";
	}

	public String telaNovo() {
		return "/instituicao/novo";
	}

	public String telaExcluir() {
		return "/instituicao/excluir";
	}

	public String telaEditar() {
		return "/instituicao/editar";
	}

	public String salvaIntituicao() {
		if (dao.salvar(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String editaIntituicao() {
		if (dao.update(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String excluiInstituicao() {
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
