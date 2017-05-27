package systemanalysis.movieticket.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public void Showing(){}
	
	@RequestMapping(method = RequestMethod.GET, value = "/comingsoon")
	public void comingsoon() {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema")
	public void cinema(@RequestParam(value="date", required=false) String date, @RequestParam(value="locationId", required=false) int location, @RequestParam(value="sortId", required=false) int sort) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film")
	public void film(@RequestParam(value="showType", required=false) String showtype, @RequestParam(value="locationId", required=false) int location, @RequestParam(value="sortId", required=false) int sort) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmId}")
	public void filmdetail(@PathVariable(value="filmId") int filmId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/film/actor/{actorId}")
	public void actordetail(@PathVariable(value="actorId") int actorId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cinema/{cinemaId}")
	public void cinemadetail(@PathVariable(value="cinemaId") int cinemaId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/playlist/{cinemaId}/{filmId}")
	public void playlist(@PathVariable(value="cinemaId") int cinemaId, @PathVariable(value="filmId") int filmId) {}
	
	@RequestMapping(method = RequestMethod.GET, value = "/seat/{cinemaId}/{filmId}/{playlistId}")
	public void seatdetail(@PathVariable(value="cinemaId") int cinemaId, @PathVariable(value="filmId") int filmId, @PathVariable(value="playlistId") int playlistId) {}
}
