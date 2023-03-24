package web.dao;

import web.model.User;

import java.util.List;

public interface UserDaoHibernate {

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}
