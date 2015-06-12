package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.dao.AwardDao;
import uoc.edu.svrKpax.vo.Award;

public class AwardBOImp implements AwardBO {

	private SessionBO sBo;
	private AwardDao awDao;

	@Override
	public Boolean addAward(int idProficiency, int maxLevel, int idGame, String descripAward, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Award objAward = new Award(idProficiency, maxLevel, idGame, descripAward);
				awDao.addAward(objAward);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delAward(int idAward, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Award objAward = awDao.getAwardById(idAward);
				awDao.delAward(objAward);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Award getAward(int idAward, String campusSession) {
		Award objAward = null;
		try {
			if(sBo.validateSession(campusSession)!=null) {
				objAward = awDao.getAwardById(idAward);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objAward;
	}
       
	@Override
	public List<Award> getAllAwards(String campusSession) {
		List<Award> allAwards = new ArrayList<Award>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allAwards = awDao.getAllAwards();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allAwards;
	}
	
		
	public void setawDao(AwardDao awDao) {
		this.awDao = awDao;
	}

	public AwardDao getawDao() {
		return awDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
