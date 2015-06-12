package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.UserAbility;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Ability;

public interface UserAbilityDao {
	
	public UserAbility getUserAbility(String userName, String abilityName);
	public void addUserAbility(UserAbility objUserAbility);
	public void delUserAbility(UserAbility objUserAbility);
	public List<UserAbility> getAllUserAbilities();
}
