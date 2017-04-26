package systemanalysis.movieticket.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PreferenceId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name="emailaddress", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	@Column(name="preference", columnDefinition = "")
	private String preference;
	
	public void SetUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	public String getPreference() {
		return preference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preference == null) ? 0 : preference.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreferenceId other = (PreferenceId) obj;
		if (preference == null) {
			if (other.preference != null)
				return false;
		} else if (!preference.equals(other.preference))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "PreferenceId [user=" + user + ", preference=" + preference + "]";
	}
}
