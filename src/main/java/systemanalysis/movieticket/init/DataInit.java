package systemanalysis.movieticket.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import systemanalysis.movieticket.persistence.entity.Cinema;
import systemanalysis.movieticket.persistence.entity.Film;
import systemanalysis.movieticket.persistence.entity.PlayList;
import systemanalysis.movieticket.persistence.service.MovieService;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

@SuppressWarnings("restriction")
@Component
public class DataInit {
	
	private String[] cinema={"万达电影院", "火山湖电影院", "金逸电影院", "星星电影院"};
	private String[] location = {"增城市", "白云区", "天河区", "海珠区", "越秀区", "荔湾区", "黄埔区", "番禺区", "花都区", "南沙区", "从化区"};
	private String[] sort = {"sale", "premiereDate", "score", "fname"};
	private String[] area = {"大陆", "美国", "日本", "其他", "其他", "其他"};
	private String[] showtype = {"爱情", "喜剧", "冒险", "恐怖", "动作", "其他"};
	private String[] movie = {"海边的曼彻斯特", "一条狗的使命", "斯隆女士", "爱乐之城", "太空旅客", "四月是你的谎言"};
	private float[] decimal = {0, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
	private String[] playtime = {"00:00", "08:00", "10:00", "13:00", "18:00", "20:00"};
	
	@Autowired
	private MovieService movieservice;
	
	@PostConstruct
	public void datainit() {
		//System.out.println("ok...................................");
		initCinema();
		initMovie();
		initPlayList();
	}
	
	void initCinema() {
		for (String l:location) {
			Random r = new Random();
			int j = r.nextInt(4);
			//System.out.println(j + "...................");
			for (int i = 0; i < j; i++) {
				movieservice.setCinema(cinema[i], l);
			}
		}
	}
	
	void initMovie() {
		int date = 20170607;
		for (int i = 0; i < 6; i++) {
			String[] type = {showtype[i]};
			Random r = new Random();
			float score = decimal[r.nextInt(10)] + 7;
			movieservice.setMovie(i, movie[i], type, area[i], 0, date, score);
			date++;
		}
	}
	
	void initPlayList() {
		List<Cinema> cinemas = movieservice.findAllCinema();
		List<Film> films = movieservice.findAllFilm();
		for (Film f:films) {
			int date = f.getPremiereDate();
			for (Cinema c:cinemas) {
				for (int j = 0; j < 7; j++) {
					for (int i = 0; i < 6; i++) {
						Random r = new Random();
						int room = r.nextInt(6) + 1;
						//System.out.println("" + room + ".................................");
						if (!movieservice.checkRoom(date, playtime[i], room))
							for (room = 1; room < 8; room++) {
								if (room == 7)
									break;
								if (movieservice.checkRoom(date, playtime[i], room))
									break;
							}
						if (room == 7)
							continue;
						movieservice.setPlayList(c, date, playtime[i], f, 30, 100, room);
					}
				}
				date++;
			}
		}
	}
}
