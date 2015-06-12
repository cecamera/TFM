package uoc.edu.svrKpax.business;

import java.util.ArrayList;
import java.util.List;

import uoc.edu.svrKpax.dao.AbilityDao;
import uoc.edu.svrKpax.dao.AbilityProficiencyDao;
import uoc.edu.svrKpax.dao.ProficiencyDao;
import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.vo.Ability;
import uoc.edu.svrKpax.vo.AbilityProficiency;
import uoc.edu.svrKpax.vo.Proficiency;


public class AbilityProficiencyBOImp implements AbilityProficiencyBO {

	private SessionBO sBo;
	private AbilityProficiencyDao apDao;
	private AbilityDao aDao;
	private ProficiencyDao pDao;

	@Override
	public Boolean addAbilityProficiency(String abilityName, String proficiencyName, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Ability ability = aDao.getAbility(abilityName);
				int abilityId = ability.getIdAbility();
				Proficiency proficiency = pDao.getProficiency(proficiencyName);
				int proficiencyId = proficiency.getIdProficiency();
				AbilityProficiency objAbilityProficiency = new AbilityProficiency(abilityId, proficiencyId);
				apDao.addAbilityProficiency(objAbilityProficiency);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delAbilityProficiency(String abilityName, String proficiencyName, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				AbilityProficiency objAbilityProficiency = apDao.getAbilityProficiency(abilityName, proficiencyName);
				apDao.delAbilityProficiency(objAbilityProficiency);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public AbilityProficiency getAbilityProficiency(String abilityName, String proficiencyName, String campusSession) {
		AbilityProficiency objAbilityProficiency = null;

		try {
			if(sBo.validateSession(campusSession)!=null) {
				objAbilityProficiency = apDao.getAbilityProficiency(abilityName, proficiencyName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objAbilityProficiency;
	}
        
        @Override
	public List<AbilityProficiency> getAllAbilityProficiencies(String campusSession) {
		List<AbilityProficiency> allAbilityProficiencies = new ArrayList<AbilityProficiency>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allAbilityProficiencies = apDao.getAllAbilityProficiencies();
			}
                } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allAbilityProficiencies;
	}
	
        public void setapDao(AbilityProficiencyDao apDao) {
		this.apDao = apDao;
	}

	public AbilityProficiencyDao getapDao() {
		return apDao;
	}
	
	public void setaDao(AbilityDao aDao) {
		this.aDao = aDao;
	}

	public AbilityDao getaDao() {
		return aDao;
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
