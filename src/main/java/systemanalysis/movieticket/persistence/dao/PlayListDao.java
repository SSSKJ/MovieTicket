package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.PlayListId;

public interface PlayListDao {
	
	List<PlayList> searchByCinemaAndFilm(int cid, int fid);
	
	PlayList findOne(PlayListId id);
	
	void deleteById(PlayListId id);
	
	List<PlayList> findAll();
	
    void create(PlayList entity);

    PlayList update(PlayList entity);

    void delete(PlayList entity);
}
