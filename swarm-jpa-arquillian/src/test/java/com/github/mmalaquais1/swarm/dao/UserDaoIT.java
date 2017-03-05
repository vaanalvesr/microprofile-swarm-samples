package com.github.mmalaquais1.swarm.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.mmalaquias1.swarm.dao.UserDao;
import com.github.mmalaquias1.swarm.model.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class UserDaoIT {

    @Deployment
    public static Archive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(User.class.getPackage())
                .addPackage(UserDao.class.getPackage())
                .addAsResource("project-it.yml", "project-defaults.yml")
                .addAsResource("META-INF/test-persistence.xml",  "META-INF/persistence.xml");
    }

    @Inject
    private UserDao userDao;

    @Test
    @InSequence(1)
    public void testInsertUser() {
        User user = new User("Batman", "batman@bat.com", "123456");
        userDao.insert(user);
        assertThat(user.getId(), is(1));
    }

    @Test
    @InSequence(2)
    public void testFindByEmail(){
        User batman = userDao.findByEmail("batman@bat.com");
        assertNotNull(batman);
    }

    @Test
    @InSequence(3)
    public void testFindByEamilNull(){
        User joker = userDao.findByEmail("joker@joker.com");
        assertNull("Joker is NULL", joker);
    }

}