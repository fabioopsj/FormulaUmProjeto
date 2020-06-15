package br.com.grandePremio.service;

import br.com.grandePremio.dao.CorridaDao;
import br.com.grandePremio.dao.ItensDao;
import br.com.grandePremio.domain.Corrida;
import br.com.grandePremio.domain.PilotosCorridaPk;
import br.com.grandePremio.domain.Resultado;
import java.util.List;


public class CorridaService {
    
    private CorridaDao corridaDao = new CorridaDao();
    private ItensDao itensResultadoDao = new ItensDao();

    public List<Corrida> listar() {
        return corridaDao.listar();
    }

    public Corrida consultar(Integer id) {
        return corridaDao.consulta(id);
    }
    
    public boolean inserir(Corrida corrida, List<Resultado> itensResultado) {
        Integer id = corridaDao.inserir(corrida);
        corrida = corridaDao.consulta(id);
        int cont = 1;
        
        for (Resultado item : itensResultado){
            PilotosCorridaPk pilotoPk = new PilotosCorridaPk();
            pilotoPk.setCorrida(corrida);
            pilotoPk.setSequencia(cont);
            item.setPilotosCorridaPk(pilotoPk);
            itensResultadoDao.inserir(item);
            cont++;
        }
        
        return true;
    }
    

    public boolean alterar(Corrida corrida, List<Resultado> itensResultado) {
        itensResultadoDao.excluir(corrida);
        int cont = 1;
        
        for (Resultado item : itensResultado) {
            PilotosCorridaPk pilotoPk = new PilotosCorridaPk();
            pilotoPk.setCorrida(corrida);
            pilotoPk.setSequencia(cont);
            item.setPilotosCorridaPk(pilotoPk);
            itensResultadoDao.inserir(item);
            cont++;
        }
        return corridaDao.alterar(corrida);
    }
    
   

    public boolean excluir(Corrida corrida) {
        return corridaDao.excluir(corrida);
    }
    
    public List<Resultado> listarItens(Corrida corrida){
        return itensResultadoDao.listar(corrida);
    }
    
}
