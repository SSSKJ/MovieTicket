package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Preference;

public interface PreferenceDao {
	
	Preference findOne(String emailaddress);

    List<Preference> findAll();

    void create(Preference entity);

    Preference update(Preference entity);

    void delete(Preference entity);

    void deleteById(String entityemailaddress);
    
    //Search all relevant preference by emailaddress and return in type List<Preference>
    List<Preference> searchAllRelevant(String emailaddress);
    //Delete all relevant preference by emailaddress
    
}
