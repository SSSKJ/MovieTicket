package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable {                            //����user���ں��û�������Ϣ����ע���õ����䣨�������� ���룬�û������绰����
	
	private static final long serialVersionUID = 1L;

	@Column(name="emailaddress", nullable=false)                       //�����������Ʋ��������Բ���Ϊ�գ�ע��ʱһ��Ҫ�ṩ
	@Id                                                                //����Ϊ����
	private String emailaddress;
	
	@Column(name="password", nullable=false)                           //�����������Ʋ��������Բ���Ϊ�գ�ע��ʱһ��Ҫ�ṩ
	private String password;
	
	@Column(name="nickname")                                           //�����������ƣ�ע��ʱ�ɲ��ṩ
	private String nickname;
	
	@Column(name="phone")                                              //�����������ƣ�ע��ʱ�ɲ��ṩ
	private String phone;
	
	public User(){}
	
	public User(String emailaddress, String password) {
		this.emailaddress = emailaddress;
		this.password = password;
		this.nickname = emailaddress;                                   //ע��ʱ��δ�ṩ��Ӧ���û�����Ĭ��Ϊע��ʱ����
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
	
	@Override                                                           //�Զ�����toString����
	public String toString() {
		return "User [emailaddress=" + emailaddress + ", password=" + password + ", nickname=" + nickname + ", phone="
				+ phone + "]";
	}
	
}
