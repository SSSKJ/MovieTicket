package systemanalysis.movieticket.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import systemanalysis.movieticket.persistence.dao.CinemaDao;
import systemanalysis.movieticket.persistence.dao.FilmDao;
import systemanalysis.movieticket.persistence.dao.FilmTypeDao;
import systemanalysis.movieticket.persistence.dao.PlayListDao;
import systemanalysis.movieticket.persistence.dao.SeatChartDao;
import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.FilmType;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.SeatChart;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private FilmDao filmdao;
	
	@Autowired
	private CinemaDao cinemadao;
	
	@Autowired
	private PlayListDao playlistdao;
	
	@Autowired
	private SeatChartDao seatchartdao;
	
	@Autowired
	private FilmTypeDao filmtypedao;
	
	private String[] location = {"增城市", "白云区", "天河区", "海珠区", "越秀区", "荔湾区", "黄埔区", "番禺区", "花都区", "南沙区", "从化区"};
	private String[] sort = {"sale", "premiereDate", "score", "fname"};
	private String[] area = {"大陆", "美国", "日本", "其他"};
	private String[] showtype = {"爱情", "喜剧", "冒险", "恐怖", "动作", "其他"};
	
	public List<Film> findAllFilm() {
		return filmdao.findAll();
	}
	
	public List<Cinema> findAllCinema() {
		return cinemadao.findAll();
	}
	
	public List<Cinema> getCinemaByLocation(Integer locationid) {
		if (locationid == null)
			return cinemadao.findAll();
		
		return cinemadao.searchByLocation(location[locationid]);
	}
	
	public List<Cinema> getCinemaByFilmLocationDate(Integer locationid, int filmid) {
		if (locationid == null)
			return cinemadao.searchByFilm(filmid);
		return cinemadao.searchByFilmNDateNLocation(filmid, location[locationid]);
	}
	
	public List<Film> getFilmNsort(Integer showtypeid, Integer locationid, Integer sortid) {
		if (sortid == null)
			sortid = 3; 
		if (showtypeid != null && locationid == null)
			return filmdao.searchByFilmType(showtype[showtypeid], sort[sortid]);
		else if (showtypeid == null && locationid != null)
			return filmdao.searchByArea(area[locationid], sort[sortid]);
		else if (showtypeid != null && locationid != null)
			return filmdao.searchByAreaNFilmType(area[locationid], showtype[showtypeid], sort[sortid]);
		else
			return filmdao.findAll();
	}
	
	public List<PlayList> getCinemaPlaylist(int date, int cinemaid) {
		return playlistdao.searchByCinema(cinemaid, date);
	}
	
	public List<PlayList> getCinemaFilmPlyalist(int fid, int cinemaid, int date) {
		return playlistdao.searchByCinemaAndFilm(cinemaid, fid, date);
	}
	
	public List<SeatChart> getSeats(int plid) {
		return seatchartdao.searchAllRelevant(plid);
	}
	
	public void setCinema(String cinema, String location) {
		List<Cinema> cinemas = cinemadao.isExist(cinema, location);
		if (!cinemas.isEmpty()) return;
		Cinema c = new Cinema();
		c.setCname(cinema);
		c.setLocation(location);
		cinemadao.create(c);
	}
	
	public PlayList getPlaylistById(int playlistid) {
		return playlistdao.findOne(playlistid);
	}
	
	public void setMovie(String movie, String[] types, String area, int sale, int date, int score) {
		List<Film> film = filmdao.isExist(movie);
		if (!film.isEmpty()) return;
		Film f = new Film();
		f.setArea(area);
		f.setFname(movie);
		f.setLength("70min");
		f.setPremiereDate(date);
		f.setSale(sale);
		f.setScore(score);
		filmdao.create(f);
		for (String type:types) {
			List<FilmType> temp = filmtypedao.isExist(type);
			FilmType filmtype;
			if (temp.isEmpty()) {
				filmtype = new FilmType();
				filmtype.setFilmType(type);
				filmtype.getFilms().add(f);
				filmtypedao.create(filmtype);
				f.getFt().add(filmtype);
			}
		}
	}
}
