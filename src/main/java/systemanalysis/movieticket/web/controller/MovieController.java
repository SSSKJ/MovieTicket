package systemanalysis.movieticket.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import systemanalysis.movieticket.persistence.dto.IdNameDto;
import systemanalysis.movieticket.persistence.dto.PlayListDto;
import systemanalysis.movieticket.persistence.dto.SeatDto;
import systemanalysis.movieticket.persistence.dto.pFilmDto;
import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.entity.SeatChart;
import systemanalysis.movieticket.persistence.service.MovieService;

@Controller
@RequestMapping("/movie")
public class MovieController {
	
	private static final Logger logger = Logger.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieservice;
	
	@ApiOperation(value = "获取现有的电影", notes = "用于获取正在热映以及将要上映的电影信息")
	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public List<IdNameDto> Showing(HttpServletResponse response) throws IOException {
		List<Film> films = movieservice.findAllFilm();
		List<IdNameDto> ins = new ArrayList<IdNameDto>();
		for (Film f:films) {
			IdNameDto in = new IdNameDto(f);
			ins.add(in);
		}
		return ins;
	}
	
	@ApiOperation(value = "筛选电影院", notes = "用于通过位置筛选电影院，若位置未传过来，则返回全部电影院，url:/movie/cinema?location=")
	@RequestMapping(method = RequestMethod.GET, value = "/cinema")
	@ResponseBody
	public List<IdNameDto> cinema(@RequestParam(value="locationid", required=false) Integer locationid, HttpServletResponse response) throws IOException {
		List<Cinema> cinemas = movieservice.getCinemaByLocation(locationid);
		List<IdNameDto> ins = new ArrayList<IdNameDto>();
		for (Cinema c:cinemas) {
			IdNameDto in = new IdNameDto(c);
			ins.add(in);
		}
		return ins;
	}
	
	
	@ApiOperation(value = "筛选电影", notes = "用于通过类型、地区以及排序顺序筛选电影，若上述全未传过来，则返回全部电影，url:/movie/film?showtypeid=&areaid=&sortid=")
	@RequestMapping(method = RequestMethod.GET, value = "/film")
	@ResponseBody
	public List<IdNameDto> film(HttpServletResponse response, @RequestParam(value="showtypeid", required=false) Integer showtypeid, @RequestParam(value="areaid", required=false) Integer areaid, @RequestParam(value="sortid", required=false) Integer sortid) throws IOException {
		List<Film> films = movieservice.getFilmNsort(showtypeid, areaid, sortid);//locationid -> areaid
		List<IdNameDto> ins = new ArrayList<IdNameDto>();
		for (Film f:films) {
			IdNameDto in = new IdNameDto(f);
			ins.add(in);
		}
		return ins;
	}
	
	@ApiOperation(value = "获取特定影院的所有放映表", notes = "用于获取给定id的电影院在某一天的所有放映表，其中date参数必传，url:/movie/cinema/{cinemaid}?date=")
	@RequestMapping(method = RequestMethod.GET, value = "/cinema/{cinemaid}")//all playlist
	@ResponseBody
	public  List<pFilmDto> cinemadetail(HttpServletResponse response, @RequestParam(value="date") int date, @PathVariable(value="cinemaid") int cinemaid) throws IOException {
		 List<PlayList> playlists = movieservice.getCinemaPlaylist(date, cinemaid);
		 String movie = "";
		 List<pFilmDto> pfilmdtos = new ArrayList<pFilmDto>();
		 pFilmDto pfilmdto = null;
		 for (PlayList p:playlists) {
			 if (!movie.equals(p.getFilm().getFname())) {
				 if (pfilmdto != null)
					 pfilmdtos.add(pfilmdto);
				 movie = p.getFilm().getFname();
				 pfilmdto = new pFilmDto(p);
			 }
			 PlayListDto pdto =  new PlayListDto(p);
			 pfilmdto.getPlaylists().add(pdto);
		 }
		 return pfilmdtos;
	}
	
	@ApiOperation(value = "获取放映特定电影的电影院", notes = "用于获取放映特定电影的电影院信息，若未传位置，则返回所有放映这部电影的电影院，url:/movie/film/{filmid}?locationid=")
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmid}")
	public List<IdNameDto> getCinemawithfilm(HttpServletResponse response, @RequestParam(value="locationid", required=false) Integer locationid, @PathVariable(value="filmid") int filmid) throws IOException {
		List<Cinema> cinemas = movieservice.getCinemaByFilmLocationDate(locationid, filmid);
		List<IdNameDto> ins = new ArrayList<IdNameDto>();
		for (Cinema c:cinemas) {
			IdNameDto in = new IdNameDto(c);
			ins.add(in);
		}
		return ins;
	}
	
	@ApiOperation(value = "获取具体某部电影在某电影院某天的放映信息", notes = "用于获取具体某部电影在某电影院某天的所有放映表")
	@RequestMapping(method = RequestMethod.GET, value = "/film/{filmid}/{cinemaid}/{date}")
	public List<PlayListDto> playlist(HttpServletResponse response, @PathVariable(value="cinemaid") int cinemaid, @PathVariable(value="filmid") int filmid, @PathVariable(value="date") int date) throws IOException {
		List<PlayList> playlists = movieservice.getCinemaFilmPlyalist(filmid, cinemaid, date);
		List<PlayListDto> playlistdtos = new ArrayList<PlayListDto>();
		for (PlayList p:playlists) {
			PlayListDto playlistdto = new PlayListDto(p);
			playlistdtos.add(playlistdto);
		}
		return playlistdtos;
	}
	
	@ApiOperation(value = "获取某放映表的座位信息", notes = "用于获取某放映表的所有座位信息")
	@RequestMapping(method = RequestMethod.GET, value = "/seat/{playlistid}")
	public List<SeatDto> getseats(HttpServletResponse response,  @PathVariable(value="playlistid") int playlistid) throws IOException {
		List<SeatChart> seatcharts = movieservice.getSeats(playlistid);
		List<SeatDto> seats = new ArrayList<SeatDto>();
		for (SeatChart s:seatcharts) {
			SeatDto seat = new SeatDto(s);
			seats.add(seat);
		}
		return seats;
	}
}
