package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.Badge;

public class BadgeDaoImpl extends HibernateDaoSupport implements BadgeDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public Badge getBadge(String nameBadge) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Badge.class);
		criteria.add(Restrictions.eq("nameBadge", nameBadge));
		return (Badge) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
	public Badge getBadgeById(int idBadge) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Badge.class);
		criteria.add(Restrictions.eq("idBadge", idBadge));
		return (Badge) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addBadge(Badge objBadge) {
		getHibernateTemplate().saveOrUpdate(objBadge);
	}

	@Override
	public void delBadge(Badge objBadge) {
		getHibernateTemplate().delete(objBadge);
	}

	@Override
	public List<Badge> getAllBadges() {
		return getHibernateTemplate().find("from Badge");
	}

}
