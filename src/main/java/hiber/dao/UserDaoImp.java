package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCarParams (String model, int series) {
      String hqlQuery = "from Car WHERE  model = '" + model + "' AND series=" + series;
      List listCars = sessionFactory.getCurrentSession().createQuery(hqlQuery).getResultList();
      if (!listCars.isEmpty()){
         hqlQuery = "from User WHERE id=" + ((Car) listCars.get(0)).getId();
         List usersList = sessionFactory.getCurrentSession().createQuery(hqlQuery).getResultList();
         if (!usersList.isEmpty()){
            return (User) usersList.get(0);
         } else {
            return new User();
         }
      } else {
         return new User();
      }
   }



}
