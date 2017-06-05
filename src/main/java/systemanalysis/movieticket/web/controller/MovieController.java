package systemanalysis.movieticket.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.SeatChart;
import systemanalysis.movieticket.persistence.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public void Showing(HttpServletResponse response) throws IOException {
		List<Film> films = movieservice.findAllFilm();
		JSONArray j = new JSONArray();
		for (Film f:films) {
			JSONObject jo = new JSONObject();
			jo.accumulate("id", f.getFid());
			jo.accumulate("name", f.getFname());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema")
	public void cinema(@RequestParam(value="locationid", required=false) Integer locationid, HttpServletResponse response) throws IOException {
		List<Cinema> cinemas = movieservice.getCinemaByLocation(locationid);
		JSONArray j = new JSONArray();
		for (Cinema c:cinemas) {
			JSONObject jo = new JSONObject();
			jo.accumulate("id", c.getCid());
			jo.accumulate("name", c.getCname());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film")
	public void film(HttpServletResponse response, @RequestParam(value="showtypeid", required=false) Integer showtypeid, @RequestParam(value="locationid", required=false) Integer locationid, @RequestParam(value="sortid", required=false) Integer sortid) throws IOException {
		List<Film> films = movieservice.getFilmNsort(showtypeid, locationid, sortid);
		JSONArray j = new JSONArray();
		for (Film f:films) {
			JSONObject jo = new JSONObject();
			jo.accumulate("id", f.getFid());
			jo.accumulate("name", f.getFname());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema/{cinemaid}")//all playlist
	public void cinemadetail(HttpServletResponse response, @RequestParam(value="date") int date, @PathVariable(value="cinemaid") int cinemaid) throws IOException {
		 List<PlayList> playlists = movieservice.getCinemaPlaylist(date, cinemaid);
		 JSONArray j = new JSONArray();
		 String movie = "";
		 for (PlayList p:playlists) {
			 if (!movie.equals(p.getFilm().getFname()))
				 movie = p.getFilm().getFname();
			 JSONObject jo = new JSONObject();
			 JSONObject jm = new JSONObject();
			 jo.accumulate("id", p.getPlid());
			 jo.accumulate("room", p.getsRoom());
			 jo.accumulate("time", p.getPlayTime());
			 jo.accumulate("price", p.getPrice());
			 jm.accumulate("name", movie);
			 jm.accumulate("filmid", p.getFilm().getFid());
			 jm.accumulate("playlists", jo);
			 j.add(jm);
		 }
		 response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmid}")
	public void getCinemawithfilm(HttpServletResponse response, @RequestParam(value="locationid", required=false) Integer locationid, @PathVariable(value="filmid") int filmid) throws IOException {
		List<Cinema> cinemas = movieservice.getCinemaByFilmLocationDate(locationid, filmid);
		JSONArray j = new JSONArray();
		for (Cinema c:cinemas) {
			JSONObject jo = new JSONObject();
			jo.accumulate("id", c.getCid());
			jo.accumulate("name", c.getCname());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmid}/{cinemaid}/{date}")
	public void playlist(HttpServletResponse response, @PathVariable(value="cinemaid") int cinemaid, @PathVariable(value="filmid") int filmid, @PathVariable(value="date") int date) throws IOException {
		List<PlayList> playlists = movieservice.getCinemaFilmPlyalist(filmid, cinemaid, date);
		JSONArray j = new JSONArray();
		for (PlayList p:playlists) {
			JSONObject jo = new JSONObject();
			jo.accumulate("id", p.getPlid());
			jo.accumulate("time", p.getPlayTime());
			jo.accumulate("price", p.getPrice());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/seat/{playlistid}")
	public void getseats(HttpServletResponse response,  @PathVariable(value="playlistid") int playlistid) throws IOException {
		List<SeatChart> seatcharts = movieservice.getSeats(playlistid);
		JSONArray j = new JSONArray();
		for (SeatChart s:seatcharts) {
			JSONObject jo = new JSONObject();
			jo.accumulate("seatid", s.getId());
			jo.accumulate("row", s.getRow());
			jo.accumulate("col", s.getColumn());
			jo.accumulate("isAvailable", s.isAvailable());
			j.add(jo);
		}
		response.getWriter().write(j.toString());
	}
}
