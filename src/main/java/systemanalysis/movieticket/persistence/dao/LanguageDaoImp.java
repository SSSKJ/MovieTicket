package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Language;

@Repository
public class LanguageDaoImp extends AbstractJpaDAO<Language> implements LanguageDao {
	
	public LanguageDaoImp() {
		super();
		setClazz(Language.class);
	}

	@SuppressWarnings("unchecked")
	public List<Language> searchAllRelevantLanguage(int fid) {
		String queryString = "select l from Language l where l.films.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<Language> result = query.getResultList();
		return result;
	}
}
