package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.AbilityProficiency;
import uoc.edu.svrKpax.vo.Proficiency;

public class AbilityProficiencyDaoImpl extends HibernateDaoSupport implements AbilityProficiencyDao {

	@Override
	public AbilityProficiency getAbilityProficiency(String abilityName, String proficiencyName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AbilityProficiency.class);
		criteria.add(Restrictions.eq("abilityName", abilityName));
		criteria.add(Restrictions.eq("proficiencyName", proficiencyName));
		return (AbilityProficiency) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addAbilityProficiency(AbilityProficiency objAbilityProficiency) {
		getHibernateTemplate().saveOrUpdate(objAbilityProficiency);
	}

	@Override
	public void delAbilityProficiency(AbilityProficiency objAbilityProficiency) {
		getHibernateTemplate().delete(objAbilityProficiency);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AbilityProficiency> getAllAbilityProficiencies() {
		return getHibernateTemplate().find("from AbilityProficiency");
	}

}
