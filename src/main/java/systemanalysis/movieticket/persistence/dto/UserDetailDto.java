package systemanalysis.movieticket.persistence.dto;

import systemanalysis.movieticket.persistence.entity.User;

public class UserDetailDto {
	
	String email;
	String nickname;
	String phone;
	
	public UserDetailDto() {}
	
	public UserDetailDto(User user) {
		email = user.getEmailaddress();
		nickname = user.getNickname();
		phone = user.getPhone();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
}
