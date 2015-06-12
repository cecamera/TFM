package uoc.edu.svrKpax.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import uoc.edu.svrKpax.dao.UserAbilityDao;
import uoc.edu.svrKpax.dao.UserDao;
import uoc.edu.svrKpax.dao.AbilityDao;
import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.vo.UserAbility;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Ability;

public class UserAbilityBOImp implements UserAbilityBO {

	private SessionBO sBo;
	private UserAbilityDao uaDao;
	private UserDao uDao;
	private AbilityDao aDao;

	@Override
	public Boolean addUserAbility(String userName, String abilityName, int abilityLevel, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				User user = uDao.getUserForUserName(userName);
				Ability ability = aDao.getAbility(abilityName);
				int userId = user.getIdUser();
				int abilityId = ability.getIdAbility();
				UserAbility objUserAbility = new UserAbility(userId, abilityId, abilityLevel);
				uaDao.addUserAbility(objUserAbility);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delUserAbility(String userName, String abilityName, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				UserAbility objUserAbility = uaDao.getUserAbility(userName, abilityName);
				uaDao.delUserAbility(objUserAbility);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public UserAbility getUserAbility(String userName, String abilityName, String campusSession) {
		UserAbility objUserAbility = null;

		try {
			if(sBo.validateSession(campusSession)!=null) {
				objUserAbility = uaDao.getUserAbility(userName, abilityName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objUserAbility;
	}
        
        @Override
	public List<UserAbility> getAllUserAbilities(String campusSession) {
		List<UserAbility> allUserAbilities = new ArrayList<UserAbility>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allUserAbilities = uaDao.getAllUserAbilities();
			}
                } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allUserAbilities;
	}
	
        public void setuaDao(UserAbilityDao uaDao) {
		this.uaDao = uaDao;
	}

	public UserAbilityDao getuaDao() {
		return uaDao;
	}
	
	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

	public UserDao getuDao() {
		return uDao;
	} 

	public void setaDao(AbilityDao aDao) {
		this.aDao = aDao;
	}

	public AbilityDao getaDao() {
		return aDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
