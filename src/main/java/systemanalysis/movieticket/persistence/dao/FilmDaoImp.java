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
	
	public List<Film> isExist(final String fname) {
		
		String queryString = "select f from Film f where f.fname=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fname);
		List<Film> result = query.getResultList();
		return result;
	}
	
	public void deleteById(final int fid) {
		final Film entity = findOne(fid);
		delete(entity);
	}

	public List<Film> searchByActor(int aid) {
		String queryString = "select f from Film f join f.a a where a.aid=?1";//if this doesn't work,try below
		//String queryString = ""select f from Film f, Actor a where a.aid in elements (f.a) and a.aid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, aid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByDirector(int did) {
		String queryString = "select f from Film f join f.d d where d.did=?1";//if this doesn't work,try below
		//String queryString = ""select f from Film f, Director d where d.did in elements (f.d) and d.did=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, did);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByFilmVersion(int fvid) {
		String queryString = "select f from Film f join f.fv fv where fv.fvid=?1";//if this doesn't work,try below
		//String queryString = ""select f from Film f, FilmVersion fv where fv.fvid in elements (f.fv) and fv.fvid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, fvid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByLanguage(int lid) {
		String queryString = "select f from Film f join f.l l where l.lid=?1";//if this doesn't work,try below
		//String queryString = ""select f from Film f, Language l where l.lid in elements (f.l) and l.lid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, lid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByCinema(int cid) {
		String queryString = "select f from Film f join f.cinemas c where c.cid=?1";//if this doesn't work,try below
		//String queryString = ""select f from Film f, Cinema c where c.cid in elements (f.cinema) and c.cid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, cid);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByFilmType(String filmtype, String sort) {
		String queryString = "select f from Film f join f.ft ft where ft.ftid=?1 order by f." + sort;//if this doesn't work,try below
		//String queryString = ""select f from Film f, FilmType ft where ft.ftid in elements (f.ft) and ft.ftid=?1 order by f." + sort;
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, filmtype);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByArea(String area, String sort) {
		String queryString = "select f from Film f where f.area=?1 order by f." + sort;//if this doesn't work,try below
		//String queryString = ""select f from Film f, FilmType ft where ft.ftid in elements (f.ft) and ft.ftid=?1 order by f." + sort;
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, area);
		List<Film> result = query.getResultList();
		return result;
	}

	public List<Film> searchByAreaNFilmType(String area, String typename, String sort) {
		String queryString = "select f from Film f join f.ft ft where ft.filmType=?1 and f.area=?2 order by f." + sort;//if this doesn't work,try below
		//String queryString = ""select f from Film f, FilmType ft where ft.ftid in elements (f.ft) and ft.ftid=?1 and f.area=?2 order by f." + sort;
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, typename);
		query.setParameter(2, area);
		List<Film> result = query.getResultList();
		return result;
	}

	

}
