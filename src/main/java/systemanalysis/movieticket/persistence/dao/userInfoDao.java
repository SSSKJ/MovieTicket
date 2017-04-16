package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import systemanalysis.movieticket.persistence.entity.userInfo;

public interface userInfoDao {
	userInfo findOne(String username);

    List<userInfo> findAll();

    void create(userInfo entity);

    userInfo update(userInfo entity);

    void delete(userInfo entity);

    void deleteById(String entityusername);
}
