package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    // CRUD

    @Transactional
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Transactional
    public void delete(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }

    @Transactional
    public void deleteById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
    }

    @Transactional
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Transactional
    public void update(long id, String name) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        user.setName(name);
        session.saveOrUpdate(user);
    }

    @Transactional
    public void getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createQuery("from User", User.class).list().forEach(System.out::println);
    }

    @Transactional
    public void getUserByUsername(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        User resultList = query.getSingleResult();
        System.out.println(resultList);

    }
}
