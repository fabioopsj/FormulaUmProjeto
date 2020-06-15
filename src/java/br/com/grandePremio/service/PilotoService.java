package br.com.grandePremio.service;

import br.com.grandePremio.dao.PilotoDao;
import br.com.grandePremio.domain.Piloto;
import java.util.List;


public class PilotoService {
    
    private PilotoDao pilotoDao = new PilotoDao();

    public List<Piloto> listar() {
        return pilotoDao.listar();
    }


    public Piloto consultar(Integer id) {
        return pilotoDao.consulta(id);
    }

    public boolean inserir(Piloto piloto) {
        return pilotoDao.inserir(piloto);
    }

    public boolean alterar(Piloto piloto) {
        return pilotoDao.alterar(piloto);
    }

    public boolean excluir(Piloto piloto) {
        return pilotoDao.excluir(piloto);
    }

    
}
