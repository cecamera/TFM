package uoc.edu.svrKpax.business;

import java.util.Date;
import java.util.List;

import uoc.edu.svrKpax.vo.UserAward;


public interface UserAwardBO {
	
     	public Boolean addUserAward(String userName, int idAward, int levelAward, String campusSession);
     	public Boolean delUserAward(String userName, int idAward, String campusSession);
     	public UserAward getUserAward(String userName, int idAward, String campusSession);
	public List<UserAward> getAllUserAwards(String campusSession);

}
