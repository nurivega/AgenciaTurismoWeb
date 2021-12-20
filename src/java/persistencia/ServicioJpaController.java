/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Paquete;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Servicio;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author nurivega
 */
public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    ServicioJpaController() {
       emf= Persistence.createEntityManagerFactory("AgenciaTurismoWeb_PU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getListaPaquetes() == null) {
            servicio.setListaPaquetes(new ArrayList<Paquete>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Paquete> attachedListaPaquetes = new ArrayList<Paquete>();
            for (Paquete listaPaquetesPaqueteToAttach : servicio.getListaPaquetes()) {
                listaPaquetesPaqueteToAttach = em.getReference(listaPaquetesPaqueteToAttach.getClass(), listaPaquetesPaqueteToAttach.getCodigo());
                attachedListaPaquetes.add(listaPaquetesPaqueteToAttach);
            }
            servicio.setListaPaquetes(attachedListaPaquetes);
            em.persist(servicio);
            for (Paquete listaPaquetesPaquete : servicio.getListaPaquetes()) {
                listaPaquetesPaquete.getListaServicios().add(servicio);
                listaPaquetesPaquete = em.merge(listaPaquetesPaquete);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getCodigo());
            List<Paquete> listaPaquetesOld = persistentServicio.getListaPaquetes();
            List<Paquete> listaPaquetesNew = servicio.getListaPaquetes();
            List<Paquete> attachedListaPaquetesNew = new ArrayList<Paquete>();
            for (Paquete listaPaquetesNewPaqueteToAttach : listaPaquetesNew) {
                listaPaquetesNewPaqueteToAttach = em.getReference(listaPaquetesNewPaqueteToAttach.getClass(), listaPaquetesNewPaqueteToAttach.getCodigo());
                attachedListaPaquetesNew.add(listaPaquetesNewPaqueteToAttach);
            }
            listaPaquetesNew = attachedListaPaquetesNew;
            servicio.setListaPaquetes(listaPaquetesNew);
            servicio = em.merge(servicio);
            for (Paquete listaPaquetesOldPaquete : listaPaquetesOld) {
                if (!listaPaquetesNew.contains(listaPaquetesOldPaquete)) {
                    listaPaquetesOldPaquete.getListaServicios().remove(servicio);
                    listaPaquetesOldPaquete = em.merge(listaPaquetesOldPaquete);
                }
            }
            for (Paquete listaPaquetesNewPaquete : listaPaquetesNew) {
                if (!listaPaquetesOld.contains(listaPaquetesNewPaquete)) {
                    listaPaquetesNewPaquete.getListaServicios().add(servicio);
                    listaPaquetesNewPaquete = em.merge(listaPaquetesNewPaquete);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicio.getCodigo();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            List<Paquete> listaPaquetes = servicio.getListaPaquetes();
            for (Paquete listaPaquetesPaquete : listaPaquetes) {
                listaPaquetesPaquete.getListaServicios().remove(servicio);
                listaPaquetesPaquete = em.merge(listaPaquetesPaquete);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
