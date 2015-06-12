package uoc.edu.svrKpax.business;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import uoc.edu.svrKpax.util.Security;
import uoc.edu.svrKpax.dao.AwardImageDao;
import uoc.edu.svrKpax.vo.AwardImage;

public class AwardImageBOImp implements AwardImageBO {

	private SessionBO sBo;
	private AwardImageDao aiDao;

	@Override
	public Boolean addAwardImage(int idAward, int levelAward, String imageAward, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				AwardImage objAwardImage = new AwardImage(idAward, levelAward, imageAward);
				aiDao.addAwardImage(objAwardImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean delAwardImage(int idAwardImage, String campusSession) {
		try {
			if (sBo.validateSession(campusSession) != null) {
				AwardImage objAwardImage = aiDao.getAwardImageById(idAwardImage);
				aiDao.delAwardImage(objAwardImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public AwardImage getAwardImage(int idAwardImage, String campusSession) {
		AwardImage objAwardImage = null;
		try {
			if(sBo.validateSession(campusSession)!=null) {
				objAwardImage = aiDao.getAwardImageById(idAwardImage);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return objAwardImage;
	}
       
	@Override
	public List<AwardImage> getAllAwardImages(String campusSession) {
		List<AwardImage> allAwardImages = new ArrayList<AwardImage>();
		try {
			if (sBo.validateSession(campusSession) != null) {
				allAwardImages = aiDao.getAllAwardImages();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return allAwardImages;
	}
	
		
	public void setaiDao(AwardImageDao aiDao) {
		this.aiDao = aiDao;
	}

	public AwardImageDao getaiDao() {
		return aiDao;
	}

	public SessionBO getsBo() {
		return sBo;
	}

	public void setsBo(SessionBO sBo) {
		this.sBo = sBo;
	}

}
