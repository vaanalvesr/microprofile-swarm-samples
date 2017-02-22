package com.github.mmalaquias1.swarm.resource;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

public class ManagerFactory {

    @PersistenceContext
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    public EntityManager create(){
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em){
        if(em.isOpen()){
            em.close();
        }
    }
}
