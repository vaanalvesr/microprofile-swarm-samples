package com.github.mmalaquias1.swarm.dao;

import com.github.mmalaquias1.swarm.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PersonDao {

    @PersistenceContext(unitName = "h2-unit")
    private EntityManager em;

    public void create(Person entity) {
        em.persist(entity);
    }

    public void deleteById(Long id) {
        Person entity = em.find(Person.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public Person update(Person entity) {
        return em.merge(entity);
    }

    public List<Person> listAll() {
        return em.createQuery("SELECT DISTINCT p FROM Person p ORDER BY p.id", Person.class).getResultList();
    }
}
