package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="fid", nullable=false)
	@Id
	@GeneratedValue
	private int fid;
	
	@Column(name="fname", nullable=false)
	private String fname;
	
	@Column(name="introduction", nullable=false)
	private String introduction;
	
	@Column(name="length", nullable=false)
	private String length;
	
	@Column(name="score", nullable=false)
	private String score;//may should be an int???
	
	@Column(name="area", nullable=false)
	private String area;
	
	@Column(name="premiereDate", nullable=false)
	private String premiereDate;
	
	@Column(name="posterURL", nullable=false)
	private String posterURL;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.film")
	private List<Actor> a = new ArrayList<Actor>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.film")
	private List<FilmVersion> fv = new ArrayList<FilmVersion>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.film")
	private List<FilmType> ft = new ArrayList<FilmType>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.film")
	private List<Director> d = new ArrayList<Director>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.film")
	private List<ScreenRoom> l = new ArrayList<ScreenRoom>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="film")
	private List<PlayList> playLists =  new ArrayList<PlayList>();
	
	
	public List<Actor> getA() {
		return a;
	}

	public void setA(List<Actor> a) {
		this.a = a;
	}

	public List<FilmVersion> getFv() {
		return fv;
	}

	public void setFv(List<FilmVersion> fv) {
		this.fv = fv;
	}

	public List<FilmType> getFt() {
		return ft;
	}

	public void setFt(List<FilmType> ft) {
		this.ft = ft;
	}

	public List<Director> getD() {
		return d;
	}

	public void setD(List<Director> d) {
		this.d = d;
	}

	public List<ScreenRoom> getL() {
		return l;
	}

	public void setL(List<ScreenRoom> l) {
		this.l = l;
	}

	public Film() {}
	
	public Film(int fid, String fname, String introduction, String length, String score, String area,
			String premiereDate, String posterURL) {
		this.fid = fid;
		this.fname = fname;
		this.introduction = introduction;
		this.length = length;
		this.score = score;
		this.area = area;
		this.premiereDate = premiereDate;
		this.posterURL = posterURL;
	}



	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(String premiereDate) {
		this.premiereDate = premiereDate;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}
	
	@Override                                                           
	public String toString() {
		return "Film [fid=" + fid + ", fname=" + fname 
				+ ", introduction=" + introduction 
				+ ", length=" + length 
				+ ", scroe=" + score
				+ ", area=" + area
				+ ", posterURL=" +posterURL
				+ ", premiereDate=" + premiereDate
				+ "]";
	}
}
