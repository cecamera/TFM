package uoc.edu.svrKpax.business;

import java.util.Date;
import java.util.List;

import uoc.edu.svrKpax.vo.UserBadge;


public interface UserBadgeBO {
	
     	public Boolean addUserBadge(String userName, String badgeName, Date dateAchiev, String campusSession);
     	public Boolean delUserBadge(String userName, String badgeName, String campusSession);
     	public UserBadge getUserBadge(String userName, String badgeName, String campusSession);
	public List<UserBadge> getAllUserBadges(String campusSession);

}
