package service;

import model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void removeUserById(int id);

    User getUser(int id);
}
