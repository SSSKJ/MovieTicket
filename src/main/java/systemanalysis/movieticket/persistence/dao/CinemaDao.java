package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;

public interface CinemaDao {
	
	List<Cinema> searchByFilm(int fid);
	
	List<Cinema> searchByLocation(String location);
	
	Cinema findOne(int cid);
	
	Cinema findOne(String cname);
	
	void deleteById(int cid);
	
	List<Cinema> findAll();
	
    void create(Cinema entity);

    Cinema update(Cinema entity);

    void delete(Cinema entity);
}
