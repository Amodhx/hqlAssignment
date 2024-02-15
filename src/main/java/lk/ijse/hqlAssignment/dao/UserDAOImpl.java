package lk.ijse.hqlAssignment.dao;

import lk.ijse.hqlAssignment.config.FactoryConfiguration;
import lk.ijse.hqlAssignment.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDAOImpl {
    public List<User> getAllUsers(){
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        return session.createQuery("from User").getResultList();
    }
}
