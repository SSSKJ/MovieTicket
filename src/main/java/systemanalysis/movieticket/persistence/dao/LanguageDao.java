package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Language;

public interface LanguageDao {
	
	List<Language> searchAllRelevantLanguage(int fid);
	
	//Language findOne(LanguageId aid);
	
	List<Language> findAll();
	
    void create(Language entity);

    Language update(Language entity);

    void delete(Language entity);
}
