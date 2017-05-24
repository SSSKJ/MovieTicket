package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Language;
import systemanalysis.movieticket.persistence.entity.Film;

public interface LanguageDao {
	
	List<Film> searchAllRelevant(String language);
	
	//Language findOne(LanguageId aid);
	
	List<Language> findAll();
	
    void create(Language entity);

    Language update(Language entity);

    void delete(Language entity);
}
