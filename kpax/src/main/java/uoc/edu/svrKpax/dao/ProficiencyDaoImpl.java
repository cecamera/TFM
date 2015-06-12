package uoc.edu.svrKpax.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.Proficiency;

public class ProficiencyDaoImpl extends HibernateDaoSupport implements ProficiencyDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public Proficiency getProficiency(String nameProficiency) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Proficiency.class);
		criteria.add(Restrictions.eq("nameProficiency", nameProficiency));
		return (Proficiency) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}
	
	public Proficiency getProficiencyById(int idProficiency) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Proficiency.class);
		criteria.add(Restrictions.eq("idProficiency", idProficiency));
		return (Proficiency) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public void addProficiency(Proficiency objProficiency) {
		getHibernateTemplate().saveOrUpdate(objProficiency);
	}

	@Override
	public void delProficiency(Proficiency objProficiency) {
		getHibernateTemplate().delete(objProficiency);
	}

	@Override
	public List<Proficiency> getAllProficiencies() {
		return getHibernateTemplate().find("from Proficiency");
	}

}
