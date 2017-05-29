package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.CinemaDao;
import systemanalysis.movieticket.persistence.dao.FilmDao;
import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private FilmDao filmdao;
	
	@Autowired
	private CinemaDao cinemadao;
	
	public List<Film> findAllFilm() {
		return filmdao.findAll();
	}
	
	public List<Cinema> getCinemaByLocation(String location) {
		return cinemadao.searchByLocation(location);
	}
}
