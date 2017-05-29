package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.FilmType;

//filmtype is like act,love,...ect
@Repository
public class FilmTypeDaoImp extends AbstractJpaDAO<FilmType> implements FilmTypeDao {
	
	public FilmTypeDaoImp() {
		super();
		setClazz(FilmType.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Film> searchAllRelevant(String filmtype) {
		//don't know if it is right
		String queryString = "select ft.id.film from FilmType ft where ft.id.filmtype=?1";
				
		Query query = entityManager.createQuery(queryString);
		
		query.setParameter(1, filmtype);
		List<Film> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<FilmType> searchAllRelevantFilmType(int fid) {
		String queryString = "select ft from FilmType ft where ft.films.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<FilmType> result = query.getResultList();
		return result;
	}
}
