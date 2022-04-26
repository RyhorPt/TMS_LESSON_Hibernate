package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    // CRUD

    @Transactional
    public void save(User user) {
        Session currentSession = entityManager.getCurrentSession();
        currentSession.save(user);
    }

    @Transactional
    public void delete(User user){
        Session currentSession = entityManager.getCurrentSession();
        currentSession.delete(user);
    }

    @Transactional
    public void deleteById(long id) {
        Session currentSession = entityManager.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

    @Transactional
    public void update(User user) {
        Session session = entityManager.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Transactional
    public void update(long id, String name) {
        Session session = entityManager.getCurrentSession();
        User user = session.get(User.class, id);
        user.setName(name);
        session.saveOrUpdate(user);
    }

    @Transactional
    public void getAll() {
        Session currentSession = entityManager.getCurrentSession();
        currentSession.createQuery("from User", User.class).list().forEach(System.out::println);
    }

    @Transactional
    public void getUserByUsername(String username) {
        Session currentSession = entityManager.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        User resultList = query.getSingleResult();
        System.out.println(resultList);

    }
}
