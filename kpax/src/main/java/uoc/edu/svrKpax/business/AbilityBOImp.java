package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.dao.AbilityDao;
import uoc.edu.svrKpax.vo.Ability;

public class AbilityBOImp implements AbilityBO {

	private SessionBO sBo;
	private AbilityDao aDao;

	@Override
	public Boolean addAbility(String nameAbility, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Ability objAbility = new Ability(nameAbility);
				aDao.addAbility(objAbility);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delAbility(String nameAbility, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Ability objAbility = aDao.getAbility(nameAbility);
				aDao.delAbility(objAbility);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Ability getAbility(String nameAbility, String campusSession) {
		Ability objAbility = null;
		try {
			if(sBo.validateSession(campusSession)!=null) {
				objAbility = aDao.getAbility(nameAbility);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objAbility;
	}
       
	@Override
	public List<Ability> getAllAbilities(String campusSession) {
		List<Ability> allAbilities = new ArrayList<Ability>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allAbilities = aDao.getAllAbilities();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allAbilities;
	}
	
		
	public void setaDao(AbilityDao aDao) {
		this.aDao = aDao;
	}

	public AbilityDao getaDao() {
		return aDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
