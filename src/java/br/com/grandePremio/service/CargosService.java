package br.com.grandePremio.service;

import br.com.grandePremio.dao.CargosDao;
import br.com.grandePremio.domain.Cargos;
import java.util.List;

public class CargosService {
    private CargosDao cargosDao = new CargosDao();

    public List<Cargos> listar() {
        return cargosDao.listar();
    }

    public Cargos consultar(Integer id) {
        return cargosDao.consulta(id);
    }

    public boolean inserir(Cargos cargos) {
        return cargosDao.inserir(cargos);
    }

    public boolean alterar(Cargos cargos) {
        return cargosDao.alterar(cargos);
    }

    public boolean excluir(Cargos cargos) {
        return cargosDao.excluir(cargos);
    }

}
