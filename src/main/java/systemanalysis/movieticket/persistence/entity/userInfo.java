package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userInfo")
public class userInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="USERNAME")
	@Id
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PREFERNECE", columnDefinition="")
	private String preference;
	
	public userInfo(){}
	
	public userInfo(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
