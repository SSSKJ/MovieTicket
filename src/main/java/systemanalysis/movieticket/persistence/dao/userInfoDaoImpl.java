package systemanalysis.movieticket.persistence.dao;

import systemanalysis.movieticket.persistence.entity.userInfo;

public class userInfoDaoImpl extends AbstractJpaDAO<userInfo> implements userInfoDao {
	
	public userInfoDaoImpl() {
		super();
		setClazz(userInfo.class);
	}
}
