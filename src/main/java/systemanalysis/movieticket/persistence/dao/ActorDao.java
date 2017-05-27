package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Actor;

public interface ActorDao {
	
	List<Actor> searchAllRelevantActor(int fid);
	//Actor findOne(ActorId aid);
	
	List<Actor> findAll();
	
    void create(Actor entity);

    Actor update(Actor entity);

    void delete(Actor entity);
}
