package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {                            //定义user表，内含用户基本信息，如注册用的邮箱（主键）， 密码，用户名，电话号码
	
	private static final long serialVersionUID = 1L;

	@Column(name="emailaddress", nullable=false)                       //定义属性名称并声明属性不能为空，注册时一定要提供
	@Id                                                                //声明为主键
	private String emailaddress;
	
	@Column(name="password", nullable=false)                           //定义属性名称并声明属性不能为空，注册时一定要提供
	private String password;
	
	@Column(name="nickname")                                           //定义属性名称，注册时可不提供
	private String nickname;
	
	@Column(name="phone")                                              //定义属性名称，注册时可不提供
	private String phone;
	
	public User(){}
	
	public User(String emailaddress, String password) {
		this.emailaddress = emailaddress;
		this.password = password;
		this.nickname = emailaddress;                                   //注册时若未提供相应的用户名则默认为注册时邮箱
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
	
	@Override                                                           //自动生成toString函数
	public String toString() {
		return "User [emailaddress=" + emailaddress + ", password=" + password + ", nickname=" + nickname + ", phone="
				+ phone + "]";
	}
	
}
