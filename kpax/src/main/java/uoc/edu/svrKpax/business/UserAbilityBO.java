package uoc.edu.svrKpax.business;

import java.util.Date;
import java.util.List;

import uoc.edu.svrKpax.vo.UserAbility;


public interface UserAbilityBO {
	
     	public Boolean addUserAbility(String userName, String abilityName, int abilityLevel, String campusSession);
     	public Boolean delUserAbility(String userName, String abilityName, String campusSession);
     	public UserAbility getUserAbility(String userName, String abilityName, String campusSession);
	public List<UserAbility> getAllUserAbilities(String campusSession);

}
