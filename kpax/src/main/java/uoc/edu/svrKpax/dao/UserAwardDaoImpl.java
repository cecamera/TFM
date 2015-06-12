package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.UserAward;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Award;

public class UserAwardDaoImpl extends HibernateDaoSupport implements UserAwardDao {

	@Override
	public UserAward getUserAward(String userName, int idAward) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserAward.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("idAward", idAward));
		return (UserAward) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addUserAward(UserAward objUserAward) {
		getHibernateTemplate().saveOrUpdate(objUserAward);
	}

	@Override
	public void delUserAward(UserAward objUserAward) {
		getHibernateTemplate().delete(objUserAward);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAward> getAllUserAwards() {
		return getHibernateTemplate().find("from UserAward");
	}

}
