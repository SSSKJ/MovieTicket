package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.PlayList;

public interface PlayListDao {
	
	List<PlayList> searchByCinemaAndFilm(int cid, int fid);
	
	PlayList findOne(int plid);
	
	void deleteById(int plid);
	
	List<PlayList> findAll();
	
    void create(PlayList entity);

    PlayList update(PlayList entity);

    void delete(PlayList entity);
}
