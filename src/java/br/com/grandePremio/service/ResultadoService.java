package br.com.grandePremio.service;

import br.com.grandePremio.dao.ResultadoDao;
import br.com.grandePremio.domain.Resultado;
import java.util.List;


public class ResultadoService {

    private ResultadoDao resultadoDao = new ResultadoDao();

    public List<Resultado> listar() {
        return resultadoDao.listar();
    }


    public Resultado consultar(Integer id) {
        return resultadoDao.consulta(id);
    }

    public boolean inserir(Resultado resultado) {
        return resultadoDao.inserir(resultado);
    }

    public boolean alterar(Resultado resultado) {
        return resultadoDao.alterar(resultado);
    }

    public boolean excluir(Resultado resultado) {
        return resultadoDao.excluir(resultado);
    }


}
