package lk.ijse.hqlAssignment.service;

import lk.ijse.hqlAssignment.dao.UserDAOImpl;
import lk.ijse.hqlAssignment.dto.UserDTO;
import lk.ijse.hqlAssignment.entity.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {
    UserDAOImpl userDAO = new UserDAOImpl();
    public ArrayList<UserDTO> getAllUsers(){
        ArrayList<UserDTO> arrayList = new ArrayList<>();
        for (User u : userDAO.getAllUsers()){
            arrayList.add(new UserDTO(u.getUsername(),u.getPassword()));
        }
        return arrayList;
    }
}
