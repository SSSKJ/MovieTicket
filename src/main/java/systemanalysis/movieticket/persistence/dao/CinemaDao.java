package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Cinema;

public interface CinemaDao {
	
	List<Cinema> searchByFilm(int fid);
	
	List<Cinema> searchByLocation(String location);
	
	List<Cinema> searchByFilmNDateNLocation(int fid, String location);
	
	Cinema findOne(int cid);
	
	List<Cinema> isExist(String cname, String location);
	
	void deleteById(int cid);
	
	List<Cinema> findAll();
	
    void create(Cinema entity);

    Cinema update(Cinema entity);

    void delete(Cinema entity);
}
