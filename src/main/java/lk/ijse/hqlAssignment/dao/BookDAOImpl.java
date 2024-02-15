package lk.ijse.hqlAssignment.dao;

import lk.ijse.hqlAssignment.config.FactoryConfiguration;
import lk.ijse.hqlAssignment.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.sql.ast.tree.insert.Values;

import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl {
    public List<Book> q1(){
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Query query = session.createQuery("from Book b where b.publicationYear > :Year");
        query.setParameter("Year",2010);
        return query.getResultList();
    }

    public boolean q2(int id) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();
        int rowCount =  0 ;
        List<Book> resultList = session.createQuery("from Book ").getResultList();
        Query query = session.createQuery("update Book  b set b.price = :NewPrice where b.id = :ID");
        for (Book b :  resultList){
            if (b.getAuthor().getId() == id){
                double old = b.getPrice();
                double newp = old+((old/100)*10);
                query.setParameter("NewPrice", newp);
                query.setParameter("ID", b.getId());
                rowCount = query.executeUpdate();
            }
        }
        transaction.commit();
        return rowCount > 0 ;
    }


    public List<Book> getBooks() {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        List<Book> resultList = session.createQuery("from Book ").getResultList();
        return resultList;
    }

}
