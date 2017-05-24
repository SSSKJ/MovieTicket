package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Actor;
import systemanalysis.movieticket.persistence.entity.Director;
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.FilmType;
import systemanalysis.movieticket.persistence.entity.FilmVersion;
import systemanalysis.movieticket.persistence.entity.Language;
import systemanalysis.movieticket.persistence.entity.Cinema;

public interface FilmDao {
	List<Actor> searchAllRelevantActor(int fid);
	
	List<Director> searchAllRelevantDirector(int fid);
	
	List<FilmType> searchAllRelevantFilmType(int fid);
	
	List<FilmVersion> searchAllRelevantFilmVersion(int fid);
	
	List<Language> searchAllRelevantLanguage(int fid);
	
	List<Cinema> searchAllRelevantCinema(int fid);
	
	List<Film> searchByArea(String area);
	
	Film findOne(int fid);
	
	List<Film> findAll();
	
    void create(Film entity);

    Film update(Film entity);

    void delete(Film entity);
    
    //Delete orderform by oid
    void deleteById(int fid);
}
