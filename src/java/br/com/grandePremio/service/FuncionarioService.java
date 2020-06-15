package br.com.grandePremio.service;

import br.com.grandePremio.dao.FuncionarioDao;
import br.com.grandePremio.domain.Funcionario;
import java.util.List;


public class FuncionarioService {
    
    private FuncionarioDao funcionarioDao = new FuncionarioDao();

    public List<Funcionario> listar() {
        return funcionarioDao.listar();
    }

    public Funcionario consultar(Integer id) {
        return funcionarioDao.consulta(id);
    }

    public boolean inserir(Funcionario funcionario) {
        return funcionarioDao.inserir(funcionario);
    }

    public boolean alterar(Funcionario funcionario) {
        return funcionarioDao.alterar(funcionario);
    }

    public boolean excluir(Funcionario funcionario) {
        return funcionarioDao.excluir(funcionario);
    }

}
