package systemanalysis.movieticket.persistence.dao;

import org.springframework.stereotype.Repository;
import systemanalysis.movieticket.persistence.entity.userInfo;

@Repository
public class userInfoDaoImpl extends AbstractJpaDAO<userInfo> implements userInfoDao {
	
	public userInfoDaoImpl() {
		super();
		setClazz(userInfo.class);
	}
}
