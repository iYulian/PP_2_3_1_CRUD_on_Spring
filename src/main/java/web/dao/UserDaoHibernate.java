package web.dao;

import web.model.User;

import java.util.List;

public interface UserDaoHibernate {

    void saveUser(String name, String lastName, byte age);

    void removeUserById(long id);

    List<User> getAllUsers();

    void changeUser(long id, String name, String lastname, byte age);
}
