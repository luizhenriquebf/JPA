package teste.basico;

import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA");
        EntityManager em = emf.createEntityManager();

       em.getTransaction().begin();

        Usuario u = em.find(Usuario.class,3L);
        u.setEmail("luiz.farias@cyrela.com.br");
        u.setName("Luiz Henrique");

        em.detach(u); // Tira a sincronização do objeto

        em.merge(u);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
