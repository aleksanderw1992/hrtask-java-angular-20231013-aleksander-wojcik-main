package com.astec.service;

import com.astec.model.Component;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ComponentService {

    @PersistenceContext(unitName = "astecPU")
    private EntityManager em;

    // Default constructor
    public ComponentService() {}

    // Constructor for testing purposes
    ComponentService(EntityManager em) {
        this.em = em;
    }
    public Component save(Component component) {
        em.persist(component);
        return component;
    }

    public void delete(Long id) {
        Component component = em.find(Component.class, id);
        if (component != null) {
            em.remove(component);
        }
    }

    public List<Component> findAll() {
        return em.createQuery("SELECT c FROM Component c", Component.class).getResultList();
    }

    public Component findById(Long id) {
        return em.find(Component.class, id);
    }

}
