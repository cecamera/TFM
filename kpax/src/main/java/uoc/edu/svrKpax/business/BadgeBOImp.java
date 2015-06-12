package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.dao.BadgeDao;
import uoc.edu.svrKpax.vo.Badge;

public class BadgeBOImp implements BadgeBO {

	private SessionBO sBo;
	private BadgeDao bDao;

	@Override
	public Boolean addBadge(String nameBadge, String descripBadge, String imageBadge, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Badge objBadge = new Badge(nameBadge, descripBadge, imageBadge);
				bDao.addBadge(objBadge);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delBadge(String nameBadge, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				Badge objBadge = bDao.getBadge(nameBadge);
				bDao.delBadge(objBadge);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Badge getBadge(String nameBadge, String campusSession) {
		Badge objBadge = null;
		try {
			if(sBo.validateSession(campusSession)!=null) {
				objBadge = bDao.getBadge(nameBadge);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objBadge;
	}
       
	@Override
	public List<Badge> getAllBadges(String campusSession) {
		List<Badge> allBadges = new ArrayList<Badge>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allBadges = bDao.getAllBadges();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allBadges;
	}
	
		
	public void setbDao(BadgeDao bDao) {
		this.bDao = bDao;
	}

	public BadgeDao getbDao() {
		return bDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
