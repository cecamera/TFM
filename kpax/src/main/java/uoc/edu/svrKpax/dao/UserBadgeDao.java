package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.UserBadge;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Badge;

public interface UserBadgeDao {
	
	public UserBadge getUserBadge(String userName, String badgeName);
	public void addUserBadge(UserBadge objUserBadge);
	public void delUserBadge(UserBadge objUserBadge);
	public List<UserBadge> getAllUserBadges();
}
