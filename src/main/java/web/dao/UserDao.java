package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void removeUserById(int id);

    List<User> getAllUsers();

    User getUserByUserName(String userName);

    User getUserById(int id);
}