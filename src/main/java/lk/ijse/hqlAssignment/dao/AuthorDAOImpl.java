package lk.ijse.hqlAssignment.dao;

import lk.ijse.hqlAssignment.config.FactoryConfiguration;
import lk.ijse.hqlAssignment.entity.Author;
import org.hibernate.Session;

import java.util.List;

public class AuthorDAOImpl {
    public List<Author> getAll() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        List<Author> resultList = session.createQuery("from Author ").getResultList();
        return resultList;
    }
}
