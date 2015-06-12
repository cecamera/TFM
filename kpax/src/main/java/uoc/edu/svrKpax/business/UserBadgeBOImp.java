package uoc.edu.svrKpax.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uoc.edu.svrKpax.dao.UserBadgeDao;
import uoc.edu.svrKpax.dao.UserDao;
import uoc.edu.svrKpax.dao.BadgeDao;
import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.vo.UserBadge;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Badge;

public class UserBadgeBOImp implements UserBadgeBO {

	private SessionBO sBo;
	private UserBadgeDao ubDao;
	private UserDao uDao;
	private BadgeDao bDao;

	@Override
	public Boolean addUserBadge(String userName, String badgeName, Date dateAchiev, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				User user = uDao.getUserForUserName(userName);
				Badge badge = bDao.getBadge(badgeName);
				int userId = user.getIdUser();
				int badgeId = badge.getIdBadge();
				UserBadge objUserBadge = new UserBadge(userId, badgeId, dateAchiev);
				ubDao.addUserBadge(objUserBadge);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delUserBadge(String userName, String badgeName, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				UserBadge objUserBadge = ubDao.getUserBadge(userName, badgeName);
				ubDao.delUserBadge(objUserBadge);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserBadge getUserBadge(String userName, String badgeName, String campusSession) {
		UserBadge objUserBadge = null;

		try {
			if(sBo.validateSession(campusSession)!=null) {
				objUserBadge = ubDao.getUserBadge(userName, badgeName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objUserBadge;
	}
        
        @Override
	public List<UserBadge> getAllUserBadges(String campusSession) {
		List<UserBadge> allUserBadges = new ArrayList<UserBadge>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allUserBadges = ubDao.getAllUserBadges();
			}
                } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allUserBadges;
	}
	
        public void setubDao(UserBadgeDao ubDao) {
		this.ubDao = ubDao;
	}

	public UserBadgeDao getubDao() {
		return ubDao;
	}
	
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

	public UserDao getuDao() {
		return uDao;
	} 

	public void setbDao(BadgeDao bDao) {
		this.bDao = bDao;
	}

	public BadgeDao getbDao() {
		return bDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
