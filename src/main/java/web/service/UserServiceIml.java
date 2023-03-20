package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDaoHibernate;
import web.model.User;

import java.util.List;

@Service
public class UserServiceIml implements UserService{

    @Autowired
    private  UserDaoHibernate userDao;


    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void changeUser(long id, String name, String lastname, byte age) {
        userDao.changeUser(id,name, lastname, age);
    }
}
