package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.FilmVersion;

public interface FilmVersionDao {
	
	List<FilmVersion> searchAllRelevantFilmVersion(int fid);
	//Language findOne(LanguageId aid);
	
	List<FilmVersion> findAll();
	
    void create(FilmVersion entity);

    FilmVersion update(FilmVersion entity);

    void delete(FilmVersion entity);
}
