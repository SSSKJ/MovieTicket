package systemanalysis.movieticket.persistence.dao;

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
}
