package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.UserAward;
import uoc.edu.svrKpax.vo.User;
import uoc.edu.svrKpax.vo.Award;

public interface UserAwardDao {
	
	public UserAward getUserAward(String userName, int idAward);
	public void addUserAward(UserAward objUserAward);
	public void delUserAward(UserAward objUserAward);
	public List<UserAward> getAllUserAwards();

}
