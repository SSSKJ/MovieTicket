package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.FilmType;
import systemanalysis.movieticket.persistence.entity.Film;

public interface FilmTypeDao {
	List<Film> searchAllRelevant(String filmtype);
	
	//FilmType findOne(FilmTypeId aid);
	
	List<FilmType> findAll();
	
    void create(FilmType entity);

    FilmType update(FilmType entity);

    void delete(FilmType entity);
}
