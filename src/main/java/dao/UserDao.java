package dao;

import model.User;

import java.util.List;

public interface UserDao {
    //void createUsersTable();

    void dropUsersTable();

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    void cleanUsersTable();

    User getUser(int id);
}