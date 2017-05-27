package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Film;

public interface FilmDao {
	
	List<Film> searchByActor(int aid);
	
	List<Film> searchByDirector(int did);
	
	List<Film> searchByFilmType(int ftid);
	
	List<Film> searchByFilmVersion(int fvid);
	
	List<Film> searchByLanguage(int lid);
	
	List<Film> searchByCinema(int cid);
	
	List<Film> searchByArea(String area);
	
	Film findOne(int fid);
	
	Film findOne(String fname);
	
	List<Film> findAll();
	
    void create(Film entity);

    Film update(Film entity);

    void delete(Film entity);
    
    //Delete orderform by oid
    void deleteById(int fid);
}
