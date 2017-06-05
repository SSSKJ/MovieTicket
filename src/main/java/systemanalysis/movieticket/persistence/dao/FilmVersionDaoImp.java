package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.FilmVersion;

//this is like 3D/2D/IMAX
@Repository
public class FilmVersionDaoImp extends AbstractJpaDAO<FilmVersion> implements FilmVersionDao{
		
	public  FilmVersionDaoImp() {
		super();
		setClazz(FilmVersion.class);
	}

	@SuppressWarnings("unchecked")
	public List<FilmVersion> searchAllRelevantFilmVersion(int fid) {
		String queryString = "select distinct fv from Film f,FilmVersion fv where fv.fvid in elements (f.fv) and f.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<FilmVersion> result = query.getResultList();
		return result;
	}
	
}
