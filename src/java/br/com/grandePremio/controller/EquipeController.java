package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Equipe;
import br.com.grandePremio.service.EquipeService;
import br.com.grandePremio.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "equipeMB")
@SessionScoped
public class EquipeController implements Serializable{  
    private Equipe equipe = new Equipe();
    private List<Equipe> equipes;
    private EquipeService equipeService = new EquipeService();

    public EquipeController() {
        listar();
    }

    public void listar() {
        equipes = equipeService.listar();
    }

    public String novo() {
        equipe = new Equipe();
        System.out.println(equipe.getId() + equipe.getNome());
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }

    public String salvar() {
        System.out.println("AQ ESAT" +equipe.getNome());
        if (equipeService.inserir(equipe)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar equipe");
        return null;
    }

    public String alterar() {
        if (equipeService.alterar(equipe)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a equipe");
        return null;
    }

    public String excluir(Equipe equipe) {
        if (equipeService.excluir(equipe)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Equipe excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a equipe");
        return null;

    }

    public String buscaDados(Equipe equipe) {
        this.equipe = equipe;
        return "alter.xhtml?faces-redirect=true";
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public EquipeService getEquipeService() {
        return equipeService;
    }

    public void setEquipeService(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
    
}
