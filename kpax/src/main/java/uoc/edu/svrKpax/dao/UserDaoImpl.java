package uoc.edu.svrKpax.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Badge;
import uoc.edu.svrKpax.vo.UserBadge;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.UserAbility;
import uoc.edu.svrKpax.vo.ResQueryAbilities;
import uoc.edu.svrKpax.vo.ResQueryBadges;
import uoc.edu.svrKpax.vo.ResQueryProficiencies;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	private User uVo;

	@Override
	public void saveUser(User user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser(User user) {
		return getHibernateTemplate().find("from User");
	}

	@Override
	public User getUser(int userId) {
		return (User) getHibernateTemplate().get(User.class, userId);
	}

	@Override
	public User getUserForUserName(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("login", userName));
		return (User) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public User getUserForUid(String uid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("secret", uid));
		return (User) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(criteria));
	}

	@Override
	public List<ResQueryBadges> getUserBadges(String username) {
		DetachedCriteria criteria1 = DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("login", username));
		uVo = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria1));
		int userId = uVo.getIdUser();
		String theQuery ="SELECT B.nameBadge, B.descripBadge, B.imageBadge, UB.dateAchiev FROM Badge B, UserBadge UB WHERE UB.idUser = ? AND UB.idBadge = B.idBadge ORDER BY UB.dateAchiev";
		Object[] queryParams = { userId };
		List<ResQueryBadges> queryResult = getHibernateTemplate().find(theQuery, queryParams);
		return queryResult;
	}

	@Override
	public List<ResQueryAbilities> getUserAbilities(String username) {
		DetachedCriteria criteria1 = DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("login", username));
		uVo = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria1));
		int userId = uVo.getIdUser();
		String theQuery ="SELECT A.idAbility, A.nameAbility, UA.levelAbility FROM Ability A, UserAbility UA WHERE UA.idUser = ? AND UA.idAbility = A.idAbility ORDER BY UA.levelAbility DESC, A.nameAbility";
		Object[] queryParams = { userId };
		List<ResQueryAbilities> queryResult = getHibernateTemplate().find(theQuery, queryParams);
		return queryResult;
	}
	
	//@Override
	//public List<Ability> getUserAbilities(String username) {
	//	DetachedCriteria criteria1 = DetachedCriteria.forClass(User.class);
	//	criteria1.add(Restrictions.eq("login", username));
	//	uVo = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria1));
	//	DetachedCriteria criteria2 = DetachedCriteria.forClass(UserAbility.class, "ua");
	//	criteria2.add(Restrictions.eq("idUser", uVo.getIdUser()));
	//	List<UserAbility> userAbilityRelationships = getHibernateTemplate().findByCriteria(criteria2);
        //      List<Ability> listOfAbilities = new ArrayList<Ability>();
	//	int abilityId;
	//	Ability theAbility;
        //      for (UserAbility ua : userAbilityRelationships) {
	//		DetachedCriteria criteria3 = DetachedCriteria.forClass(Ability.class);
	//		criteria3.add(Restrictions.eq("idAbility", ua.getIdAbility()));
	//		theAbility = (Ability) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria3));
        //        	listOfAbilities.add(theAbility);
	//	}
	//	return listOfAbilities;
	//}

	@Override
	public List<ResQueryProficiencies> getUserProficiencies(String username, int idAbility) {
		DetachedCriteria criteria1 = DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("login", username));
		uVo = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria1));
		int userId = uVo.getIdUser();
		String theQuery ="SELECT P.nameProficiency, UA.levelAward, AI.imageAward FROM AbilityProficiency AP, Proficiency P, UserAward UA, AwardImage AI, Award A WHERE UA.idUser = ? AND UA.idAward = A.idAward AND A.idAward = AI.idAward AND UA.levelAward = AI.levelAward AND A.idProficiency = P.idProficiency AND P.idProficiency = AP.idProficiency AND AP.idAbility = ? ORDER BY UA.levelAward DESC, P.nameProficiency";
		Object[] queryParams = { userId, idAbility };
		List<ResQueryProficiencies> queryResult = getHibernateTemplate().find(theQuery, queryParams);
		return queryResult;
	}

}
