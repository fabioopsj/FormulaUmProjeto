package br.com.grandePremio.dao;

import br.com.grandePremio.domain.Corrida;
import br.com.grandePremio.domain.Resultado;
import br.com.grandePremio.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class ItensDao {
    
    public List<Resultado> listar(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Resultado> itensResultado = session.createQuery("from Resultado where idCorrida = " + corrida.getId() + " order by sequencia").list();
            session.getTransaction().commit();
            return itensResultado;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean inserir(Resultado itemResultado) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(itemResultado);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean alterar(Resultado itemResultado) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(itemResultado);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean excluir(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("delete Resultado where idCorrida = :idOS");
            query.setParameter("idOS", corrida.getId());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}
