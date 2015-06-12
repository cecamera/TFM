package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.Ability;

public class AbilityDaoImpl extends HibernateDaoSupport implements AbilityDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public Ability getAbility(String nameAbility) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Ability.class);
		criteria.add(Restrictions.eq("nameAbility", nameAbility));
		return (Ability) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
	public Ability getAbilityById(int idAbility) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Ability.class);
		criteria.add(Restrictions.eq("idAbility", idAbility));
		return (Ability) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addAbility(Ability objAbility) {
		getHibernateTemplate().saveOrUpdate(objAbility);
	}

	@Override
	public void delAbility(Ability objAbility) {
		getHibernateTemplate().delete(objAbility);
	}

	@Override
	public List<Ability> getAllAbilities() {
		return getHibernateTemplate().find("from Ability");
	}

}
