package cn.ppfix.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/12/18-1:03
 */
public class SessionFactoryHelper {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
}
