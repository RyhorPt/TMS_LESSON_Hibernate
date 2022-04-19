package by.tms.dao;

import by.tms.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }
}
