package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import systemanalysis.movieticket.persistence.entity.Director;

@Repository
public class DirectorDaoImp extends AbstractJpaDAO<Director> implements DirectorDao {
	
	public DirectorDaoImp() {
		super();
		setClazz(Director.class);
	}
	

	@SuppressWarnings("unchecked")
	public List<Director> searchAllRelevantDirector(int fid) {
		String queryString = "select d from Director d where d.films.fid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fid);
		List<Director> result = query.getResultList();
		return result;
	}

}
