package dao;

import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import service.UserService;
import util.Util;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {

    }

    /*@Override
    public void createUsersTable() {
        Session session = Util.getSession();
        try {
            session.beginTransaction();
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                    "(id LONG NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(255) NOT NULL, lastName VARCHAR(255) NOT NULL, " +
                    "age TINYINT NOT NULL)";
            Query query = session.createSQLQuery(sql).addEntity(User.class);

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            Util.closeFactory(session);
        }

    }*/

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession();
        try {
            session.beginTransaction();

            String tableName = "users";
            String sql = "DELETE FROM " + tableName;
            Query query = session.createSQLQuery(sql);
            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            Util.closeFactory(session);
        }
    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void removeUserById(int id) {
        User user = getUser(id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession();
        try {
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            Util.closeFactory(session);
        }
    }

    @Override
    public User getUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
