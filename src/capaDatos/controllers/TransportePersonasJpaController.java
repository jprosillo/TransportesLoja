/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDatos.controllers;

import capaDatos.TransportePersonas;
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
public class TransportePersonasJpaController implements Serializable {

    public TransportePersonasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TransportePersonas transportePersonas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transportePersonas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TransportePersonas transportePersonas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transportePersonas = em.merge(transportePersonas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transportePersonas.getIdTp();
                if (findTransportePersonas(id) == null) {
                    throw new NonexistentEntityException("The transportePersonas with id " + id + " no longer exists.");
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
            TransportePersonas transportePersonas;
            try {
                transportePersonas = em.getReference(TransportePersonas.class, id);
                transportePersonas.getIdTp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportePersonas with id " + id + " no longer exists.", enfe);
            }
            em.remove(transportePersonas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TransportePersonas> findTransportePersonasEntities() {
        return findTransportePersonasEntities(true, -1, -1);
    }

    public List<TransportePersonas> findTransportePersonasEntities(int maxResults, int firstResult) {
        return findTransportePersonasEntities(false, maxResults, firstResult);
    }

    private List<TransportePersonas> findTransportePersonasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TransportePersonas.class));
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

    public TransportePersonas findTransportePersonas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TransportePersonas.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportePersonasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TransportePersonas> rt = cq.from(TransportePersonas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
