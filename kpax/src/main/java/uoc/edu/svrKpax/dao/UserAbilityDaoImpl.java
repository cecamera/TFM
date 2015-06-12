package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.UserAbility;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Ability;

public class UserAbilityDaoImpl extends HibernateDaoSupport implements UserAbilityDao {

	@Override
	public UserAbility getUserAbility(String userName, String abilityName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserAbility.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("abilityName", abilityName));
		return (UserAbility) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addUserAbility(UserAbility objUserAbility) {
		getHibernateTemplate().saveOrUpdate(objUserAbility);
	}

	@Override
	public void delUserAbility(UserAbility objUserAbility) {
		getHibernateTemplate().delete(objUserAbility);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAbility> getAllUserAbilities() {
		return getHibernateTemplate().find("from UserAbility");
	}

}
