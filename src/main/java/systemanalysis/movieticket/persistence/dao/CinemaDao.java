package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;

public interface CinemaDao {
	
	List<Film> searchAllRelevantFilm(String cid);
	
	//Cinema findOne(CinemaId aid);
	
	List<Cinema> findAll();
	
    void create(Cinema entity);

    Cinema update(Cinema entity);

    void delete(Cinema entity);
}
