package systemanalysis.movieticket.persistence.dao;

import java.util.List;

import javax.persistence.Query;

import systemanalysis.movieticket.persistence.entity.SeatChart;

public class SeatChartDaoImp extends AbstractJpaDAO<SeatChart> implements SeatChartDao {
	
	public SeatChartDaoImp() {
		super();
		setClazz(SeatChart.class);
	}

	@SuppressWarnings("unchecked")
	public List<SeatChart> searchAllRelevant(int plid) {
		String queryString = "select sc from SeatChart sc where sc.playList.plid=?1";
		
		Query query = entityManager.createQuery(queryString);
				
		query.setParameter(1, plid);
		List<SeatChart> result = query.getResultList();
		return result;
	}

	public SeatChart findOne(int scid) {
		return entityManager.find(SeatChart.class, scid);
	}
	
	

}
