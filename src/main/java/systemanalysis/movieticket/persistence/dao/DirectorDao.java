package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Director;
import systemanalysis.movieticket.persistence.entity.Film;

public interface DirectorDao {
	List<Film> searchAllRelevant(String dname);
	
	//Director findOne(DirectorId aid);
	
	List<Director> findAll();
	
    void create(Director entity);

    Director update(Director entity);

    void delete(Director entity);
}
