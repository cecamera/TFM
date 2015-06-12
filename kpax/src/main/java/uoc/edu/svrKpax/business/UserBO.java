package uoc.edu.svrKpax.business;

import javax.ws.rs.core.Response;
import java.util.List;

import uoc.edu.svrKpax.vo.Badge;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.ResQueryAbilities;
import uoc.edu.svrKpax.vo.ResQueryBadges;
import uoc.edu.svrKpax.vo.ResQueryProficiencies;

public interface UserBO {
	
	public Response initUserUOC(String username, String password, String alias) ;
	public int validateUserUOC(String campusSession);
	
	public Response initUserELGG(String username, String password);
	public Response initSignELGG(String username,String apikey);
	
	public Response initUser(String username,String alias);
	public int validateUser(String uid) ;
	public List<ResQueryBadges> getUserBadges(String username, String campusSession);
	public List<ResQueryAbilities> getUserAbilities(String username, String campusSession);
	public List<ResQueryProficiencies> getUserProficiencies(String username, String idAbility, String campusSession);

}

