package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Director;

public interface DirectorDao {
	List<Director> searchAllRelevantDirector(int fid);
	
	//Director findOne(DirectorId aid);
	
	List<Director> findAll();
	
    void create(Director entity);

    Director update(Director entity);

    void delete(Director entity);
}
