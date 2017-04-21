package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.User;

public interface UserDao {
	User findOne(String emailaddress);

    List<User> findAll();

    void create(User entity);

    User update(User entity);

    void delete(User entity);

    void deleteById(String entityemailaddress);
}
