package com.github.mmalaquias1.swarm.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.github.mmalaquias1.swarm.model.User;

@ApplicationScoped
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public User findById(Integer id){
        return em.find(User.class, id);
    }

    public List<User> findAll(){
        return em.createQuery("FROM User u ORDER BY u.name", User.class).getResultList();
    }

    public User findByEmail(String email){
        try {
            return em.createQuery("FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Transactional
    public void insert(User user){
        em.persist(user);
    }

}
