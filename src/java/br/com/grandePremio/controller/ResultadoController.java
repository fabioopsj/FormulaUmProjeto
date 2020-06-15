package br.com.grandePremio.controller;

import br.com.grandePremio.domain.Resultado;
import br.com.grandePremio.service.ResultadoService;
import br.com.grandePremio.util.UtilMensagens;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "resultadoMB")
@SessionScoped

public class ResultadoController {
    private Resultado resultado = new Resultado();
    private List<Resultado> resultados;
    private ResultadoService resultadoService = new ResultadoService();
    public ResultadoController() {
        this.listar();
    }
    public void listar() {
        resultados = resultadoService.listar();
    }
    public String novo() {
        resultado = new Resultado();
        return "new.xhtml?faces-redirect=true";
    }
    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }
    public String salvar() {
        if (resultadoService.inserir(resultado)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Resultado salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar resultado");
        return null;
    }
    public String alterar() {
        if (resultadoService.alterar(resultado)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Resultado alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a resultado");
        return null;
    }
    public String excluir(Resultado resultado) {
        if (resultadoService.excluir(resultado)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Resultado excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a resultado");
        return null;
    }
    public String buscaDados(Resultado resultado) {
        this.resultado = resultado;
        return "alter.xhtml?faces-redirect=true";
    }
    public Resultado getResultado() {
        return resultado;
    }
    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
    public ResultadoService getResultadoService() {
        return resultadoService;
    }
    public void setResultadoService(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }
    public List<Resultado> getResultados() {
        return resultados;
    }
    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }
}
