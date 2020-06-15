package br.com.grandePremio.service;

import br.com.grandePremio.dao.EquipeDao;
import br.com.grandePremio.domain.Equipe;
import java.util.List;


public class EquipeService {
    
    private EquipeDao equipeDao = new EquipeDao();

    public List<Equipe> listar() {
        return equipeDao.listar();
    }

    public Equipe consultar(Integer id) {
        return equipeDao.consulta(id);
    }

    public boolean inserir(Equipe equipe) {
        return equipeDao.inserir(equipe);
    }

    public boolean alterar(Equipe equipe) {
        return equipeDao.alterar(equipe);
    }

    public boolean excluir(Equipe equipe) {
        return equipeDao.excluir(equipe);
    }
    
}
