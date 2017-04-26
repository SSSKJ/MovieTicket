package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {                            
	
	private static final long serialVersionUID = 1L;

	@Column(name="emailaddress", nullable=false)                       
	@Id                                                                
	private String emailaddress;
	
	@Column(name="password", nullable=false)                           
	private String password;
	
	@Column(name="nickname")                                           
	private String nickname;
	
	@Column(name="phone")                                              
	private String phone;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="preference")
	private List<Preference> p;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<OrderForm> o;
	
	public List<OrderForm> getO() {
		return o;
	}

	public void setO(List<OrderForm> o) {
		this.o = o;
	}

	public List<Preference> getP() {
		return p;
	}

	public void setP(List<Preference> p) {
		this.p = p;
	}

	public User(){}
	
	public User(String emailaddress, String password) {
		this.emailaddress = emailaddress;
		this.password = password;
		this.nickname = emailaddress;                                  
	}
	
	public String getEmailaddress() {
		return emailaddress;
	}
	
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override                                                           
	public String toString() {
		return "User [emailaddress=" + emailaddress + ", password=" + password + ", nickname=" + nickname + ", phone="
				+ phone + "]";
	}
	
}
