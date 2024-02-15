package lk.ijse.hqlAssignment.service;

import lk.ijse.hqlAssignment.dao.AuthorDAOImpl;
import lk.ijse.hqlAssignment.entity.Author;

import java.util.List;

public class AuthorServiceImpl {
    AuthorDAOImpl authorDAO = new AuthorDAOImpl();
    public List<Author> getAll() {
        return authorDAO.getAll();
    }
}
