package uoc.edu.svrKpax.business;

import java.util.ArrayList;
import java.util.List;

import uoc.edu.svrKpax.dao.UserAwardDao;
import uoc.edu.svrKpax.dao.UserDao;
import uoc.edu.svrKpax.dao.AwardDao;
import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.vo.UserAward;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Award;

public class UserAwardBOImp implements UserAwardBO {

	private SessionBO sBo;
	private UserAwardDao uawDao;
	private UserDao uDao;
	private AwardDao awDao;

	@Override
	public Boolean addUserAward(String userName, int idAward, int levelAward, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				User user = uDao.getUserForUserName(userName);
				int userId = user.getIdUser();
				UserAward objUserAward = new UserAward(userId, idAward, levelAward);
				uawDao.addUserAward(objUserAward);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delUserAward(String userName, int idAward, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				UserAward objUserAward = uawDao.getUserAward(userName, idAward);
				uawDao.delUserAward(objUserAward);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserAward getUserAward(String userName, int idAward, String campusSession) {
		UserAward objUserAward = null;

		try {
			if(sBo.validateSession(campusSession)!=null) {
				objUserAward = uawDao.getUserAward(userName, idAward);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objUserAward;
	}
        
        @Override
	public List<UserAward> getAllUserAwards(String campusSession) {
		List<UserAward> allUserAwards = new ArrayList<UserAward>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allUserAwards = uawDao.getAllUserAwards();
			}
                } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allUserAwards;
	}
	
        public void setuawDao(UserAwardDao uawDao) {
		this.uawDao = uawDao;
	}

	public UserAwardDao getuawDao() {
		return uawDao;
	}
	
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

	public UserDao getuDao() {
		return uDao;
	} 

	public void setawDao(AwardDao awDao) {
		this.awDao = awDao;
	}

	public AwardDao getawDao() {
		return awDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
