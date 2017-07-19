package cn.edu.bistu.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



/**
 * Created by Decrain on 2017/3/3.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory; //会话工厂属性。

    //构造方法私有化，保证单利模式

    private  HibernateUtil(){

    }

    static
    {
        try
        {
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static final ThreadLocal<Session> session
            = new ThreadLocal<Session>();

    public static Session getSession()
            throws HibernateException
    {
        Session s = session.get();
        if (s == null)
        {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    public static void closeSession()
            throws HibernateException
    {
        Session s = session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
}
