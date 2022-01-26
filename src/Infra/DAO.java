package Infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("JPA");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DAO (Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirTransacao() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public List<E> obterTodos(int qnt, int deslocamento) {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe nula!");
        }

        String sqpl = "select e from" + classe.getName() + "e";
        TypedQuery<E> res = em.createNamedQuery(sqpl, classe);
        res.setMaxResults(qnt);
        res.setFirstResult(deslocamento);
        return res.getResultList();
    }

    public void fechar() {
        em.close();
    }

}
