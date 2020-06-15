package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Corrida;
import br.com.grandePremio.domain.Piloto;
import br.com.grandePremio.domain.Resultado;
import br.com.grandePremio.service.CorridaService;
import br.com.grandePremio.service.PilotoService;
import br.com.grandePremio.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "corridaMB")
@SessionScoped

public class CorridaController implements Serializable {

    
    private PilotoService pilotoService = new PilotoService();
    private Piloto piloto;
    private List<Resultado> itensCorrida;
    private Resultado itemCorrida;
    private Corrida corrida = new Corrida();
    private List<Corrida> corridas;
    private CorridaService corridaService = new CorridaService();
    public CorridaController() {
        listar();
    }
    public void listar() {
        corridas = corridaService.listar();
    }
    public String novo() {
        corrida = new Corrida();
        itensCorrida = new ArrayList<>();
        itemCorrida = new Resultado();
        return "new.xhtml?faces-redirect=true";
    }
    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }
    public String salvar() {
        if (corridaService.inserir(corrida , itensCorrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar corrida");
        return null;
    }
    public String alterar() {
        if (corridaService.alterar(corrida, itensCorrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a corrida");
        return null;
    }
    public String excluir(Corrida corrida) {
        if (corridaService.excluir(corrida)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a corrida");
        return null;
    }
    public String buscaDados(Corrida corrida) {
        itemCorrida = new Resultado();
        this.corrida = corrida;
        this.itensCorrida = corridaService.listarItens(corrida);
        return "alter.xhtml?faces-redirect=true";
    }
    public void addPiloto() {
        if (itemCorrida.getPiloto() == null) {
            UtilMensagens.mensagemErro("Erro", "Informe o piloto");
        } else {
            itensCorrida.add(itemCorrida);
            itemCorrida = new Resultado();
        }
    }  
    public void removeCorrida (Resultado itemCorrida) {
        itensCorrida.remove(itemCorrida);
    }
    public void calculaTotal(){
        if(pilotoService.alterar(itemCorrida.getPiloto())){
            UtilMensagens.mensagemSucesso("Sucesso", "Corrida alterada com sucesso !");
        }
    } 
    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public CorridaService getCorridaService() {
        return corridaService;
    }

    public void setCorridaService(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    public List<Resultado> getItensCorrida() {
        return itensCorrida;
    }

    public void setItensCorrida(List<Resultado> itensCorrida) {
        this.itensCorrida = itensCorrida;
    }

    public Resultado getItemCorrida() {
        return itemCorrida;
    }

    public void setItemCorrida(Resultado itemCorrida) {
        this.itemCorrida = itemCorrida;
    }
}
