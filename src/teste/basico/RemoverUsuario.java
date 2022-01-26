package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();

        Usuario u = em.find(Usuario.class, 2L);

        if(u != null) {
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }
    }
}
