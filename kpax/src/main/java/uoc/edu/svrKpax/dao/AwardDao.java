package uoc.edu.svrKpax.dao;

import java.util.List;

import uoc.edu.svrKpax.vo.Award;

public interface AwardDao {
	
	public Award getAwardById(int idAward);
	public void addAward(Award objAward);
	public void delAward(Award objAward);
	public List<Award> getAllAwards();

}
