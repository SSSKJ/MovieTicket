package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.PreferenceId;

public class PreferenceDaoImpl extends AbstractJpaDAO<Preference> implements PreferenceDao {
	
	public PreferenceDaoImpl() {
		super();
		setClazz(Preference.class);
	}
	
	public Preference findOne(final PreferenceId id) {
        return entityManager.find(Preference.class, id);
    }
	
	public void deleteById(final PreferenceId id) {
		final Preference entity = findOne(id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Preference> searchAllRelevant(String emailaddress) {
		Query query = entityManager.createQuery("select * from preference where emailaddress = " + emailaddress);
		List<Preference> result = query.getResultList();
		return result; 
	}
	
	
}
