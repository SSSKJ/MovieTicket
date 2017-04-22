package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Preference;
import systemanalysis.movieticket.persistence.entity.PreferenceId;

public interface PreferenceDao {
	
	Preference findOne(PreferenceId id);

    List<Preference> findAll();

    void create(Preference entity);

    Preference update(Preference entity);

    void delete(Preference entity);

    void deleteById(PreferenceId id);
    
    //Search all relevant preference by emailaddress and return in type List<Preference>
    List<Preference> searchAllRelevant(String emailaddress);
    
}
