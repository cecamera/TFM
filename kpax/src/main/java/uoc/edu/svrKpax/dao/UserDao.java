package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Badge;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.ResQueryAbilities;
import uoc.edu.svrKpax.vo.ResQueryBadges;
import uoc.edu.svrKpax.vo.ResQueryProficiencies;

public interface UserDao {

	public void saveUser(User user);
	public List<User> getAllUser(User user);
	public User getUser(int userId);
	public User getUserForUserName(String userName);
	public User getUserForUid(String uid);
	public List<ResQueryBadges> getUserBadges(String username);
	public List<ResQueryAbilities> getUserAbilities(String username);
	public List<ResQueryProficiencies> getUserProficiencies(String username, int idAbility);

}
