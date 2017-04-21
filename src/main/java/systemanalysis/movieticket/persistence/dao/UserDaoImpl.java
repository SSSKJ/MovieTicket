package systemanalysis.movieticket.persistence.dao;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.User;

@Repository
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {
	
	public UserDaoImpl() {
		super();
		setClazz(User.class);
	}
	
	public User findOne(final String emailaddress) {
        return entityManager.find(User.class, emailaddress);
    }
	
	public void deleteById(final String entityemailaddress) {
		final User entity = findOne(entityemailaddress);
		delete(entity);
	}
}
