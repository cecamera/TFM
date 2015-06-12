package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import uoc.edu.svrKpax.vo.Award;


public interface AwardBO {
	
	public Boolean addAward(int idProficiency, int maxLevel, int idGame, String descripAward, String campusSession);
     	public Boolean delAward(int idAward, String campusSession);
	public Award getAward(int idAward, String campusSession);
     	public List<Award> getAllAwards(String campusSession);

}
