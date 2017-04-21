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
    
    //ͨ��emailaddress��ѯ������ص�preference������List<Preference>
    //ͨ��emailaddressɾ��������ص�preference
    
}
