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
    public void add(Object o) {
        sessionFactory.getCurrentSession().save(o);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCar() {

        return sessionFactory.getCurrentSession().createQuery("from Car ").getResultList();
    }

    @Override
    public List<User> getUserModelCar(String model, int series) {
        return sessionFactory.getCurrentSession().createQuery("select u from User u " +
                                                              "join Car c on c.id = u.id " +
                                                              "where c.model = :model and c.series = :series")
                .setParameter("model", model)
                .setParameter("series", series)
                .getResultList();
    }
}
