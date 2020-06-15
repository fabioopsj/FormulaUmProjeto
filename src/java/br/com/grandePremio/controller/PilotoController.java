package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Piloto;
import br.com.grandePremio.service.PilotoService;
import br.com.grandePremio.util.UtilMensagens;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pilotoMB")
@SessionScoped
public class PilotoController {
    private List<Piloto> pilotos;
    private Piloto piloto = new Piloto();
    private PilotoService pilotoService = new PilotoService();
    public PilotoController() {
        this.listar();
    }
    public void listar() {
        pilotos = pilotoService.listar();
    }
    public String novo() {
        piloto = new Piloto();
        return "new.xhtml?faces-redirect=true";
    }
    public String lancarPontos() {
        return "lancarPontos.xhtml?faces-redirect=true";
    }
    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }
    public String salvar() {
        if (pilotoService.inserir(piloto)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Piloto salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar piloto");
        return null;
    }
    public String alterar() {
        if (pilotoService.alterar(piloto)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Piloto alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a piloto");
        return null;
    }
    public String excluir(Piloto piloto) {
        if (pilotoService.excluir(piloto)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Piloto excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a piloto");
        return null;

    }
    public String buscaDados(Piloto piloto) {
        this.piloto = piloto;
        return "alter.xhtml?faces-redirect=true";
    }
    public Piloto getPiloto() {
        return piloto;
    }
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    public PilotoService getPilotoService() {
        return pilotoService;
    }
    public void setPilotoService(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }
    public List<Piloto> getPilotos() {
        return pilotos;
    }
    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
}
