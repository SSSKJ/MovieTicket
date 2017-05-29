package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Actor;
import systemanalysis.movieticket.persistence.entity.Film;

@Repository
public class ActorDaoImp extends AbstractJpaDAO<Actor> implements ActorDao {
	
	public ActorDaoImp() {
		super();
		setClazz(Actor.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Actor> searchAllRelevantActor(int fid) {
		//don't know if it is right
		String queryString = "select a from Actor a where a.films.fid=?1";
						
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<Actor> result = query.getResultList();
		return result;
	}
}
