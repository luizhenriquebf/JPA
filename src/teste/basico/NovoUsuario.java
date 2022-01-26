package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();

        Usuario NovoUsuario = new Usuario("Luiz", "luiz@cyrela.com.br");

        em.getTransaction().begin();
        em.persist(NovoUsuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
