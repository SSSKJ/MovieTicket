package systemanalysis.movieticket.persistence.dto;

import java.util.ArrayList;
import java.util.List;

import systemanalysis.movieticket.persistence.entity.PlayList;

public class pFilmDto {
	
	String name;
	int filmid;
	List<PlayListDto> playlists = new ArrayList<PlayListDto>();
	
	public pFilmDto() {}
	
	public pFilmDto(PlayList playlist) {
		name = playlist.getFilm().getFname();
		filmid = playlist.getFilm().getFid();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFilmid() {
		return filmid;
	}
	
	public void setFilmid(int filmid) {
		this.filmid = filmid;
	}
	
	public List<PlayListDto> getPlaylists() {
		return playlists;
	}
	
	public void setPlaylists(List<PlayListDto> playlists) {
		this.playlists = playlists;
	}
}
