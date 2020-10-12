/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author RodrigoCavotre
 */
public class JPAUtil {
    private static EntityManagerFactory emf;

    public static EntityManager getEM(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Projecto_DACPU");
        }
        return emf.createEntityManager();        
    }
    
    public static void fechaEmf(){
        emf.close();
    }
}
