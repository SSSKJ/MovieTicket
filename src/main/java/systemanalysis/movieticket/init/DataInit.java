package systemanalysis.movieticket.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import systemanalysis.movieticket.persistence.service.MovieService;

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
	
	@Autowired
	private MovieService movieservice;
	
	@PostConstruct
	public void datainit() {
		//System.out.println("ok...................................");
		initCinema();
		initMovie();
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
		int date = 20170603;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				String[] type = {showtype[i]};
				Random r = new Random();
				int score = r.nextInt(10);
				movieservice.setMovie(movie[i], type, area[i], 0, date, score);
			}
			date++;
		}
	}
}
