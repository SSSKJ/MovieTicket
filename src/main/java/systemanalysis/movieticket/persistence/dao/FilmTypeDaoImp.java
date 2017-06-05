package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.FilmType;

//filmtype is like act,love,...ect
@Repository
public class FilmTypeDaoImp extends AbstractJpaDAO<FilmType> implements FilmTypeDao {
	
	public FilmTypeDaoImp() {
		super();
		setClazz(FilmType.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<FilmType> isExist(String type) {
		
		String queryString = "select ft from FilmType ft where ft.filmType=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, type);
		List<FilmType> result = query.getResultList();
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public List<FilmType> searchAllRelevantFilmType(int fid) {
		String queryString = "select distinct ft from Film f,FilmType ft where ft.ftid in elements (f.ft) and f.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<FilmType> result = query.getResultList();
		return result;
	}
}
