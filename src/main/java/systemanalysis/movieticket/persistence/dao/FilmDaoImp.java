package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Film;

@Repository
@SuppressWarnings("unchecked")
public class FilmDaoImp extends AbstractJpaDAO<Film> implements FilmDao {
	
	public FilmDaoImp() {
		super();
		setClazz(Film.class);
	}
	
	public Film findOne(final int fid) {
		return entityManager.find(Film.class, fid);
	}
	
	public Film findOne(final String fname) {
		return entityManager.find(Film.class, fname);
	}
	
	public void deleteById(final int fid) {
		final Film entity = findOne(fid);
		delete(entity);
	}

	public List<Film> searchByActor(int aid) {
		String queryString = "select f from Film f where f.a.aid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, aid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByDirector(int did) {
		String queryString = "select f from Film f where f.d.did=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, did);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByFilmType(int ftid) {
		String queryString = "select f from Film f where f.ft.ftid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, ftid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByFilmVersion(int fvid) {
		String queryString = "select f from Film f where f.fv.fvid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fvid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByLanguage(int lid) {
		String queryString = "select f from Film f where f.l.lid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, lid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByArea(String area) {
		return null;
	}

	public List<Film> searchByCinema(int cid) {
		String queryString = "select f from Film f where f.cinemas.cid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, cid);
		List<Film> result = query.getResultList();
		return result;
	}

	

}
