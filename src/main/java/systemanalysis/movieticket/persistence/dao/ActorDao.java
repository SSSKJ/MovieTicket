package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.Actor;
import systemanalysis.movieticket.persistence.entity.ActorId;
import systemanalysis.movieticket.persistence.entity.Film;

public interface ActorDao {
	
	List<Film> searchAllRelevant(String aname);
	
	//Actor findOne(ActorId aid);
	
	List<Actor> findAll();
	
    void create(Actor entity);

    Actor update(Actor entity);

    void delete(Actor entity);
}
