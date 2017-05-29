package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.PlayList;

@Repository
public class PlayListDaoImp extends AbstractJpaDAO<PlayList> implements PlayListDao{
	
	public PlayListDaoImp() {
		super();
		setClazz(PlayList.class);
	}

	@SuppressWarnings("unchecked")
	public List<PlayList> searchByCinemaAndFilm(int cid, int fid) {
		String queryString = "select pl from PlayList pl where pl.cinema.cid=?1 && pl.film.fid=?2";
		
		Query query = entityManager.createQuery(queryString);
		query.setParameter(1, cid);
		query.setParameter(2, fid);
		List<PlayList> result = query.getResultList();
		return result; 
	}

	public PlayList findOne(int plid) {
		return entityManager.find(PlayList.class, plid);
	}

	public void deleteById(int plid) {
		final PlayList entity = findOne(plid);
		delete(entity);	
	}

	
	
}
