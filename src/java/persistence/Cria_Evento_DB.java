/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import com.evento.entity.Evento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author RodrigoCavotre
 */
public class Cria_Evento_DB {
    private EntityManager e;

    public Cria_Evento_DB() {

    }
    
    public void salva(Evento i){
        e = JPAUtil.getEM();
        EntityTransaction ex = e.getTransaction();
        ex.begin();
        e.persist(i);
        ex.commit();
        e.close();
    }
    Evento recupera(Long id){
        e = JPAUtil.getEM();
        EntityTransaction ex = e.getTransaction();
        ex.begin();
        Evento i = e.find(Evento.class, id);
        ex.commit();
        e.close();
        return i;
    }
    List<Evento> buscaNome(String nome){
        String jpaquery = "SELECT e FROM Evento e where e.nome =:var";
        e = JPAUtil.getEM();
        Query query = e.createQuery(jpaquery);
        query.setParameter("var", nome);
        List<Evento> ev = query.getResultList();
        e.close();
        return ev;
    }
    
    
    
    
    
}
