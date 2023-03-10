package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void add(Object o);

    List<User> listUsers();

    List<Car> listCar();


    List<User> getUserModelCar(String model, int series);
}
