package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Cinema; 

@Repository
public class CinemaDaoImp extends AbstractJpaDAO<Cinema> implements CinemaDao {
	
	public CinemaDaoImp() {
		super();
		setClazz(Cinema.class);
	}

	@SuppressWarnings("unchecked")
	public List<Cinema> searchByFilm(int fid) {
		String queryString = "select distinct c from Film f,Cinema c where c.cid in elements (f.cinemas) and f.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<Cinema> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cinema> searchByFilmNDateNLocation(int fid, String location) {
		String queryString = "select distinct c from Film f,Cinema c where c.cid in elements (f.cinemas) and f.fid=?1 and c.location=?2";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		query.setParameter(2, location);
		List<Cinema> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cinema> searchByLocation(String location) {
		
		String queryString = "select c from Cinema c where c.location=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, location);
		List<Cinema> result = query.getResultList();
		return result;
	}

	public Cinema findOne(final int cid) {
		return entityManager.find(Cinema.class, cid);
	}

	@SuppressWarnings("unchecked")
	public List<Cinema> isExist(final String cname, final String location) {
		
		String queryString = "select c from Cinema c where c.location=?1 and c.cname=?2";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, location);
		query.setParameter(2, cname);
		List<Cinema> result = query.getResultList();
		return result;
	}

	public void deleteById(int cid) {
		final Cinema entity = findOne(cid);
		delete(entity);
	}
	
	

}
