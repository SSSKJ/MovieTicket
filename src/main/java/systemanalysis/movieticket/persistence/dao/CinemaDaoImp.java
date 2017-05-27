package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import systemanalysis.movieticket.persistence.entity.Cinema; 

public class CinemaDaoImp extends AbstractJpaDAO<Cinema> implements CinemaDao {
	
	public CinemaDaoImp() {
		super();
		setClazz(Cinema.class);
	}

	@SuppressWarnings("unchecked")
	public List<Cinema> searchByFilm(int fid) {
		String queryString = "select c from Cinema c where c.films.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<Cinema> result = query.getResultList();
		return result;
	}

	public Cinema findOne(final int cid) {
		return entityManager.find(Cinema.class, cid);
	}

	public Cinema findOne(final String cname) {
		return entityManager.find(Cinema.class, cname);
	}

	public void deleteById(int cid) {
		final Cinema entity = findOne(cid);
		delete(entity);
	}
	
	

}
