package lk.ijse.hqlAssignment.config;

import lk.ijse.hqlAssignment.entity.Author;
import lk.ijse.hqlAssignment.entity.Book;
import lk.ijse.hqlAssignment.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(User.class).addAnnotatedClass(Author.class).addAnnotatedClass(Book.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getFactoryConfiguration(){
        return factoryConfiguration==null ? factoryConfiguration=new FactoryConfiguration() : factoryConfiguration;

    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
