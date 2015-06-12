package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.Award;

public class AwardDaoImpl extends HibernateDaoSupport implements AwardDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public Award getAwardById(int idAward) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Award.class);
		criteria.add(Restrictions.eq("idAward", idAward));
		return (Award) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addAward(Award objAward) {
		getHibernateTemplate().saveOrUpdate(objAward);
	}

	@Override
	public void delAward(Award objAward) {
		getHibernateTemplate().delete(objAward);
	}

	@Override
	public List<Award> getAllAwards() {
		return getHibernateTemplate().find("from Award");
	}

}
