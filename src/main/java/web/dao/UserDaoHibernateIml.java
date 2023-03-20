package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoHibernateIml implements UserDaoHibernate {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(String name, String lastName, byte age) {
        entityManager.getTransaction().begin();
        User user = new User(name, lastName, age);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void removeUserById(long id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = entityManager.createQuery("from User", User.class).getResultList();
        entityManager.close();
        return userList;
    }

    @Override
    public void changeUser(long id, String name, String lastname, byte age) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
