package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.UserBadge;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Badge;

public class UserBadgeDaoImpl extends HibernateDaoSupport implements UserBadgeDao {

	@Override
	public UserBadge getUserBadge(String userName, String badgeName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserBadge.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("badgeName", badgeName));
		return (UserBadge) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addUserBadge(UserBadge objUserBadge) {
		getHibernateTemplate().saveOrUpdate(objUserBadge);
	}

	@Override
	public void delUserBadge(UserBadge objUserBadge) {
		getHibernateTemplate().delete(objUserBadge);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserBadge> getAllUserBadges() {
		return getHibernateTemplate().find("from UserBadge");
	}

}
