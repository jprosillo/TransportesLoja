/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos.controllers;

import capaDatos.TransporteMercancia;
import capaDatos.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USUARIO
 */
public class TransporteMercanciaJpaController implements Serializable {

    public TransporteMercanciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TransporteMercancia transporteMercancia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transporteMercancia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TransporteMercancia transporteMercancia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transporteMercancia = em.merge(transporteMercancia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transporteMercancia.getIdTm();
                if (findTransporteMercancia(id) == null) {
                    throw new NonexistentEntityException("The transporteMercancia with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TransporteMercancia transporteMercancia;
            try {
                transporteMercancia = em.getReference(TransporteMercancia.class, id);
                transporteMercancia.getIdTm();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transporteMercancia with id " + id + " no longer exists.", enfe);
            }
            em.remove(transporteMercancia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TransporteMercancia> findTransporteMercanciaEntities() {
        return findTransporteMercanciaEntities(true, -1, -1);
    }

    public List<TransporteMercancia> findTransporteMercanciaEntities(int maxResults, int firstResult) {
        return findTransporteMercanciaEntities(false, maxResults, firstResult);
    }

    private List<TransporteMercancia> findTransporteMercanciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransporteMercancia.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TransporteMercancia findTransporteMercancia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TransporteMercancia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransporteMercanciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransporteMercancia> rt = cq.from(TransporteMercancia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
