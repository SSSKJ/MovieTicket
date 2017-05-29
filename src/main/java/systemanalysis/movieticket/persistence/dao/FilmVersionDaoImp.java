package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.FilmVersion;

//this is like 3D/2D/IMAX
@Repository
public class FilmVersionDaoImp extends AbstractJpaDAO<FilmVersion> implements FilmVersionDao{
		
	public  FilmVersionDaoImp() {
		super();
		setClazz(FilmVersion.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Film> searchAllRelevant(String versionType) {
		//don't know if it is right
		String queryString = "select fv.id.film from FilmVersion fv where fv.id.versionType=?1";
				
		Query query = entityManager.createQuery(queryString);
		
		query.setParameter(1, versionType);
		List<Film> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<FilmVersion> searchAllRelevantFilmVersion(int fid) {
		String queryString = "select fv from FilmVersion fv where fv.films.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<FilmVersion> result = query.getResultList();
		return result;
	}
	
}
