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
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public void Showing(HttpServletResponse response) throws IOException{
		List<Film> films = movieservice.findAllFilm();
		JSONArray j = new JSONArray();
		for (Film f:films)
			j.add(f.getFid());
		response.getWriter().write(j.toString());
	}
	
	//maybe useless
	@RequestMapping(method = RequestMethod.GET, value = "/comingsoon")
	public void comingsoon() {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema")
	public void cinema(@RequestParam(value="location", required=false) String location, @RequestParam(value="sortId", required=false) int sort) {
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film")
	public void film(@RequestParam(value="showType", required=false) String showtype, @RequestParam(value="locationId", required=false) int location, @RequestParam(value="sortId", required=false) int sort) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmId}")
	public void filmdetail(@PathVariable(value="filmId") int filmId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/actor/{actorId}")
	public void actordetail(@PathVariable(value="actorId") int actorId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema/{cinemaId}")
	public void cinemadetail(@RequestParam(value="date", required=false) String date, @PathVariable(value="cinemaId") int cinemaId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/playlist/{cinemaId}/{filmId}")
	public void playlist(@PathVariable(value="cinemaId") int cinemaId, @PathVariable(value="filmId") int filmId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/seat/{cinemaId}/{filmId}/{playlistId}")
	public void seatdetail(@PathVariable(value="cinemaId") int cinemaId, @PathVariable(value="filmId") int filmId, @PathVariable(value="playlistId") int playlistId) {}
}
