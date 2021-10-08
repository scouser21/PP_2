package dao;

import model.User;

import java.util.List;

public interface UserDao {
    //void createUsersTable();

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUser(int id);
}