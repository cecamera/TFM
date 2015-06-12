package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.dao.ProficiencyDao;
import uoc.edu.svrKpax.vo.Proficiency;

public class ProficiencyBOImp implements ProficiencyBO {

	private SessionBO sBo;
	private ProficiencyDao pDao;

	@Override
	public Boolean addProficiency(String nameProficiency, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Proficiency objProficiency = new Proficiency(nameProficiency);
				pDao.addProficiency(objProficiency);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delProficiency(String nameProficiency, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Proficiency objProficiency = pDao.getProficiency(nameProficiency);
				pDao.delProficiency(objProficiency);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Proficiency getProficiency(String nameProficiency, String campusSession) {
		Proficiency objProficiency = null;
		try {
			if(sBo.validateSession(campusSession)!=null) {
				objProficiency = pDao.getProficiency(nameProficiency);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objProficiency;
	}
       
	@Override
	public List<Proficiency> getAllProficiencies(String campusSession) {
		List<Proficiency> allProficiencies = new ArrayList<Proficiency>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allProficiencies = pDao.getAllProficiencies();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allProficiencies;
	}
	
		
	public void setpDao(ProficiencyDao pDao) {
		this.pDao = pDao;
	}

	public ProficiencyDao getpDao() {
		return pDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
