package lk.ijse.hqlAssignment.service;

import lk.ijse.hqlAssignment.dao.BookDAOImpl;
import lk.ijse.hqlAssignment.dto.BookDTO;
import lk.ijse.hqlAssignment.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl {
    BookDAOImpl bookDAO = new BookDAOImpl();
    public ArrayList<BookDTO> q1(){
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        List<Book> list = bookDAO.q1();
        for (Book b : list) {
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getPublicationYear(),b.getPrice(),b.getAuthor().getId()));
        }
        return arrayList;
    }

    public boolean q2(int id) {
        return bookDAO.q2(id);
    }


    public ArrayList<Double> getBookPrices() {
        ArrayList<Double> arrayList = new ArrayList<>();
        List<Book> books = bookDAO.getBooks();
        for (Book b : books){
            arrayList.add(b.getPrice());
        }
        return arrayList;
    }


}
