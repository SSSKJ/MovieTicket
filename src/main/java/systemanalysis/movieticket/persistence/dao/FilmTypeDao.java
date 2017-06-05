package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.FilmType;

public interface FilmTypeDao {
	
	List<FilmType> searchAllRelevantFilmType(int fid);
	
	//FilmType findOne(FilmTypeId aid);
	
	List<FilmType> isExist(String type);
	
	List<FilmType> findAll();
	
    void create(FilmType entity);

    FilmType update(FilmType entity);

    void delete(FilmType entity);
}
