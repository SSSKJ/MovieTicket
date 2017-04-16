package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userInfo")
public class userInfo implements Serializable {
	
	@Column(name="USERNAME")
	@Id
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PREFERNECE")
	private String preference;
	
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
