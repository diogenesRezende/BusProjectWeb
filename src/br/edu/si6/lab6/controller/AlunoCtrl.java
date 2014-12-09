package br.edu.si6.lab6.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;

import br.edu.si6.lab6.bean.AlunoTO;
import br.edu.si6.lab6.bean.InstituicaoTO;
import br.edu.si6.lab6.dao.AlunoDAO;
import br.edu.si6.lab6.dao.InstituicaoDAO;
import br.edu.si6.lab6.orm.HibernateUtil;

@ManagedBean
public class AlunoCtrl {

	private AlunoTO to;
	private AlunoDAO dao;
	private DataModel tablemodel;
	private final EntityManager em = HibernateUtil.getEntityManager();
	private List<InstituicaoTO> intituicoes;

	public AlunoCtrl() {
		to = new AlunoTO();
		dao = new AlunoDAO(this.em);
	}

	public List<InstituicaoTO> getIntituicoes() {
		InstituicaoDAO inst = new InstituicaoDAO(em);
		intituicoes = inst.getAll();
		return intituicoes;
	}

	public void setIntituicoes(List<InstituicaoTO> intituicoes) {
		this.intituicoes = intituicoes;
	}

	public AlunoTO getTo() {
		return to;
	}

	public void setTo(AlunoTO to) {
		this.to = to;
	}

	public DataModel getTablemodel() {

		tablemodel = new ListDataModel(dao.getAll());
		return tablemodel;
	}

	public void setTablemodel(DataModel tablemodel) {
		this.tablemodel = tablemodel;
	}

	public void novoAluno() {
		to = new AlunoTO();
	}

	public void selecionarAluno() {
		to = (AlunoTO) tablemodel.getRowData();
		System.out.println(to);

	}

	public String telaListar() {
		return "/aluno/lista";
	}

	public String telaNovo() {
		return "/aluno/novo";
	}

	public String telaExcluir() {
		return "/aluno/excluir";
	}

	public String telaEditar() {
		return "/aluno/editar";
	}

	public String salvaAluno() {
		dao = new AlunoDAO(this.em);
		if (dao.salvar(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String editaAluno() {
		dao = new AlunoDAO(this.em);
		if (dao.update(to)) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			contexto.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Editado com Sucesso!", ""));
			return telaListar();
		} else {
			return "erro";
		}
	}

	public String excluiAluno() {
		dao = new AlunoDAO(this.em);
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
