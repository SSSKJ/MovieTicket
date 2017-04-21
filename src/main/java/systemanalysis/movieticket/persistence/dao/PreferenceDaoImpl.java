package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import systemanalysis.movieticket.persistence.entity.Preference;

public class PreferenceDaoImpl extends AbstractJpaDAO<Preference> implements PreferenceDao {
	
	public PreferenceDaoImpl() {
		super();
		setClazz(Preference.class);
	}
	
	public Preference findOne(final String emailaddress) {
        return entityManager.find(Preference.class, emailaddress);
    }
	
	public void deleteById(final String entityemailaddress) {
		final Preference entity = findOne(entityemailaddress);
		delete(entity);
	}
	
	public List<Preference> searchAllRelevant(String emailaddress) {
		Query query = entityManager.createQuery("selete * from Preference where emailaddress = " + emailaddress);
		List<Preference> result = query.getResultList();
		return result; 
	}
	
	
}
