package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Cargos;
import br.com.grandePremio.service.CargosService;
import br.com.grandePremio.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name = "cargosMB")
@SessionScoped

public class CargosController implements Serializable {

    private Cargos cargos = new Cargos();
    private List<Cargos> cargoss;
    private CargosService cargosService = new CargosService();

    public CargosController() {
        listar();
    }

    public void listar() {
        cargoss = cargosService.listar();
    }

    public String novo() {
        cargos = new Cargos();
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }

    public String salvar() {
        if (cargosService.inserir(cargos)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Cargos salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar cargos");
        return null;
    }

    public String alterar() {
        if (cargosService.alterar(cargos)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Cargos alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a cargos");
        return null;
    }

    public String excluir(Cargos cargos) {
        if (cargosService.excluir(cargos)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Cargos excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a cargos");
        return null;

    }

    public String buscaDados(Cargos cargos) {
        this.cargos = cargos;
        return "alter.xhtml?faces-redirect=true";
    }

    public Cargos getCargos() {
        return cargos;
    }

    public void setCargos(Cargos cargos) {
        this.cargos = cargos;
    }

    public CargosService getCargosService() {
        return cargosService;
    }

    public void setCargosService(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    public List<Cargos> getCargoss() {
        return cargoss;
    }

    public void setCargoss(List<Cargos> cargoss) {
        this.cargoss = cargoss;
    }

    
}
