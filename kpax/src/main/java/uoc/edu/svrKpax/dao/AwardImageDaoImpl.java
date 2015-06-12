package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.AwardImage;

public class AwardImageDaoImpl extends HibernateDaoSupport implements AwardImageDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public AwardImage getAwardImage(int idAward, int levelAward) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AwardImage.class);
		criteria.add(Restrictions.eq("idAward", idAward));
		criteria.add(Restrictions.eq("levelAward", levelAward));
		return (AwardImage) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
	@Override
	public AwardImage getAwardImageById(int idAwardImage) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AwardImage.class);
		criteria.add(Restrictions.eq("idAwardImage", idAwardImage));
		return (AwardImage) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
	@Override
	public void addAwardImage(AwardImage objAwardImage) {
		getHibernateTemplate().saveOrUpdate(objAwardImage);
	}

	@Override
	public void delAwardImage(AwardImage objAwardImage) {
		getHibernateTemplate().delete(objAwardImage);
	}

	@Override
	public List<AwardImage> getAllAwardImages() {
		return getHibernateTemplate().find("from AwardImage");
	}

}
