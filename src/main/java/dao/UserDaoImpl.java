package dao;

import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

//    @Autowired
    //private SessionFactory sessionFactory;
//    private EntityManager entityManager;

//    @Autowired
//    private EntityManagerFactory factory;

    @PersistenceContext
    EntityManager entityManager;

    public UserDaoImpl() {

    }

    @Override
    public void saveUser(User user) {
        //EntityManager entityManager = factory.createEntityManager();
//        entityManager.getTransaction().begin();
        //entityManager.persist(user);
        entityManager.merge(user);

//        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    @Override
    public void removeUserById(int id) {
        User user = getUser(id);
       // sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        //return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
        return new ArrayList<>();
    }

    @Override
    public User getUser(int id) {
//        return sessionFactory.getCurrentSession().get(User.class, id);
        //EntityManager entityManager = factory.createEntityManager();
//        entityManager.detach(user);
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);


        return new User();
    }
}
